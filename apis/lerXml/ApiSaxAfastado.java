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
import persistencia.Afastados;

/**
 *
 * @author rafael
 */
public class ApiSaxAfastado extends DefaultHandler {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Afastados");
    EntityManager manager = factory.createEntityManager();

    List lista = null;
    Afastados part = null;
    private String tagAtual;

    public List<Afastados> getEmpList() {
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
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        tagAtual = qName;
        if (qName.equalsIgnoreCase("Parlamentar")) {
            part = new Afastados();
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

            lista.add(part);
            qName = "";
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String texto = new String(ch, start, length);

        if (tagAtual.compareTo("CodigoParlamentar") == 0) {
            part.setFKcodParlamentar(Integer.parseInt(texto));
        } else if (tagAtual.compareTo("NomeParlamentar") == 0) {
            part.setNomeAfastados(texto);
        } else if (tagAtual.compareTo("SiglaCausaAfastamento") == 0) {
            part.setSiglaCausaAfastamento(texto);
        } else if (tagAtual.compareTo("DescricaoCausaAfastamento") == 0) {
            part.setDescricaoCausaAfastamento(texto);
        }
    }

    public void fazerPersistencia(List<Afastados> pa) {

        for (Afastados p : pa) {
            manager.getTransaction().begin();
            //System.out.println(p.getDataInicio());
            manager.persist(p);
            manager.getTransaction().commit();
        }
        manager.close();
    }

}
