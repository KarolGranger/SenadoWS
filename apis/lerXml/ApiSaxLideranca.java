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
import persistencia.Lideranca;

/**
 *
 * @author rafael
 */
public class ApiSaxLideranca extends DefaultHandler {

    List lista = null;
    Lideranca lider = null;
    private String tagAtual;

    public List<Lideranca> getEmpList() {
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

    public void endDocument() {
        System.out.println("\nFim do Parsing...");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) {

        tagAtual = qName;

        if (qName.equalsIgnoreCase("Lideranca")) {
            lider = new Lideranca();
            if (lista == null) {
                lista = new ArrayList<>();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        tagAtual = "";
        if (qName.equalsIgnoreCase("Lideranca")) {
            lista.add(lider);
            qName = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String texto = new String(ch, start, length);

        if (tagAtual.compareTo("Membros") == 0) {
            lider.setMembros(Integer.parseInt(texto));
        } else if (tagAtual.compareTo("UnidLideranca") == 0) {
            lider.setNomeUnidLideranca(texto);
        } else if (tagAtual.compareTo("NomeUnidLideranca") == 0) {
            lider.setNomeUnidLideranca(texto);
        } else if (tagAtual.compareTo("CodigoParlamentar") == 0) {
            lider.setFKcodParlamentar(Integer.parseInt(texto));
        } else if (tagAtual.compareTo("Prioridade") == 0) {
            lider.setPrioridade(texto);
        } else if (tagAtual.compareTo("SiglaUnidLideranca") == 0) {
            lider.setSiglaUnidLideranca(texto);
        } else if (tagAtual.compareTo("TipoUnidLideranca") == 0) {
            lider.setTipoUnidLideranca(texto);
        } else if (tagAtual.compareTo("TipoLideranca") == 0) {
            lider.setTipoLideranca(texto);
        } else if (tagAtual.compareTo("CodigoUnidPartd") == 0) {
            lider.setCodiUnidPartido(Integer.parseInt(texto));
        }
    }

    public void fazerPersistencia(List<Lideranca> pa) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lideranca");
        EntityManager manager = factory.createEntityManager();

        for (Lideranca p : pa) {
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        }
        manager.close();
    }
}
