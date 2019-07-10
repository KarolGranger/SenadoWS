/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis.lerXml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import persistencia.Parlamentar;

/**
 *
 * @author rafael
 */
public class ApiSaxParlamentar extends DefaultHandler {

    List lista = null;
    Parlamentar par = null;
    private String tagAtual;
    int cont = 0, cont2 =0;

    public List<Parlamentar> getEmpList() {
        return lista;
    }

    public void fazerParsing(String pathArq) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;

        try {
            saxParser = factory.newSAXParser();

            saxParser.parse(new File(pathArq), this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            StringBuffer msg = new StringBuffer();
            msg.append("Erro:\n");
            msg.append(e.getMessage() + "\n");
            msg.append(e.toString());
            System.out.println(msg);
        }
    }

    @Override
    public void startDocument() {
        System.out.println("\nIniciando o Parsing...\n");
    }

    @Override
    public void endDocument() {
        System.out.println("\nFim do Parsing...");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) {

        tagAtual = qName;
        if (qName.equalsIgnoreCase("Parlamentar")) {
            par = new Parlamentar();
            if (lista == null) {
                lista = new ArrayList<>();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        tagAtual = "";
        if (qName.equalsIgnoreCase("Parlamentar")) {
            lista.add(par);
            qName = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String texto = new String(ch, start, length);

        if (tagAtual.compareTo("CodigoParlamentar") == 0) {
            switch (cont2) {
                case 0:
                    par.setCodParlamentar(Integer.parseInt(texto));
                    System.out.println(par.getCodParlamentar());
                    cont2++;
                    break;
                case 1:
                    cont2++;
                    break;
                case 2:
                    cont2 = 0;
                    break;
            }
             
        } else if (tagAtual.compareTo("NomeParlamentar") == 0) {
            switch (cont) {
                case 0:
                    par.setNome(texto);
                    cont++;
                    break;
                case 1:
                    cont++;
                    break;
                case 2:
                    cont = 0;
                    break;
            }
        } else if (tagAtual.compareTo("SexoParlamentar") == 0) {
            par.setSexo(texto);
        } else if (tagAtual.compareTo("FormaTratamento") == 0) {
            par.setFormaTratamento(texto);
        } else if (tagAtual.compareTo("SiglaPartidoParlamentar") == 0) {
            par.setSiglaPartido(texto);
        } else if (tagAtual.compareTo("UfParlamentar") == 0) {
            par.setUFParlamentar(texto);
        } else if (tagAtual.compareTo("CodigoMandato") == 0) {
            par.setCodMandato(Integer.parseInt(texto));
        } else if (tagAtual.compareTo("DescricaoParticipacao") == 0) {
            if (par.getDescMandato() == null) {
                par.setDescMandato(texto);
            }
        }
    }

    public void fazerPersistencia(List<Parlamentar> pa) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Parlamentar");
        EntityManager manager = factory.createEntityManager();

        for (Parlamentar p : pa) {
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        }
        manager.close();
    }
}
