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
import persistencia.Partidos;

/**
 *
 * @author rafael
 */
public class ApiSaxPartido extends DefaultHandler {

    List lista = null;
    Partidos part = null;
    private String tagAtual;

    public List<Partidos> getEmpList() {
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
        if (qName.equalsIgnoreCase("Partido")) {
            part = new Partidos();
            if (lista == null) {
                lista = new ArrayList<>();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        tagAtual = "";
        if (qName.equalsIgnoreCase("Partido")) {
            lista.add(part);
            qName = "";
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String texto = new String(ch, start, length);

        if (tagAtual.compareTo("Codigo") == 0) {
            part.setIdPartido(texto);
        } else if (tagAtual.compareTo("Sigla") == 0) {
            part.setSigla(texto);
        } else if (tagAtual.compareTo("Nome") == 0) {
            part.setNomePartido(texto);
        } else if (tagAtual.compareTo("DataCriacao") == 0) {
            part.setDataCriacao(texto);
        }
    }

    public void fazerPersistencia(List<Partidos> pa) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        for (Partidos p : pa) {
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        }
        manager.close();
    }
}
