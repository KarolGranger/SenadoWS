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
import persistencia.Colegiado;

/**
 *
 * @author rafael
 */
public class ApiSaxColegiado extends DefaultHandler {

    List lista = null;
    Colegiado part = null;
    private String tagAtual;

    public List<Colegiado> getEmpList() {
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
        if (qName.equalsIgnoreCase("Colegiado")) {
            part = new Colegiado();
            if (lista == null) {
                lista = new ArrayList<>();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        tagAtual = "";
        if (qName.equalsIgnoreCase("Colegiado")) {

            lista.add(part);
            qName = "";
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String texto = new String(ch, start, length);

        if (tagAtual.compareTo("NomeColegiado") == 0){
            part.setNomeColegiado(texto);
        } else if (tagAtual.compareTo("SiglaColegiado") == 0) {
            part.setSiglaColegiado(texto);
        } else if (tagAtual.compareTo("DataInicio") == 0) {
            part.setDataInicio(texto);
        } else if (tagAtual.compareTo("Titulares") == 0) {
            part.setTitulares(Integer.parseInt(texto));
        } else if (tagAtual.compareTo("Suplentes") == 0) {
            part.setSuplentes(Integer.parseInt(texto));
        }
    }

    public void fazerPersistencia(List<Colegiado> pa) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Colegiado");
        EntityManager manager = factory.createEntityManager();
        for (Colegiado p : pa) {
            manager.getTransaction().begin();
            //System.out.println(p.getDataInicio());
            manager.persist(p);
            manager.getTransaction().commit();
        }
        manager.close();
    }
}
