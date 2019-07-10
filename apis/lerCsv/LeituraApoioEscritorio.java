/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis.lerCsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import persistencia.Apoioescritorio;

/**
 *
 * @author karol
 */
public class LeituraApoioEscritorio {


    
    String linha = "";
    String separador = ";";
    String parlamentar[];
    // String cabecalhoCSV[] = {"NOME", "ESTADO", "PARTIDO" , "SETOR" , "ENDEREÇO" , "TELEFONE", "FAX"};

    public LeituraApoioEscritorio() {
    }

    public void gravar(String arquivoCSV) throws FileNotFoundException, IOException, TransformerConfigurationException, TransformerException {
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ApoioE");
        EntityManager manager = factory.createEntityManager();

        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                Apoioescritorio apoioE = new Apoioescritorio();
                String[] objetoAE = linha.split(csvDivisor);

                apoioE.setNomeParlamentar(objetoAE[0]);
                apoioE.setEstado(objetoAE[1]);
                apoioE.setSetor(objetoAE[3]);
                apoioE.setEndereco(objetoAE[4]);
                apoioE.setTelefone(objetoAE[5]);
                
                manager.getTransaction().begin();
                manager.persist(apoioE);
                manager.getTransaction().commit();
              
            }
             manager.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
             
        }
    }
}
