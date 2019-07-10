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
import persistencia.Auxilioimoveis;

/**
 *
 * @author karol
 */
public class LeituraAuxilioImoveis {
    String linha = "";
    String separador = ";";
    String parlamentar[];
    // String cabecalhoCSV[] = {NOME;ESTADO;PARTIDO;AUX�LIO-MORADIA;IM�VEL FUNCIONAL  };

    public LeituraAuxilioImoveis() {
    }

    public void gravar(String arquivoCSV) throws FileNotFoundException, IOException, TransformerConfigurationException, TransformerException {
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Auxilioimoveis");
        EntityManager manager = factory.createEntityManager();

        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                Auxilioimoveis aI = new Auxilioimoveis();
                String[] objetoAE = linha.split(csvDivisor);

                aI.setNomeParlamentar(objetoAE[0]);
                aI.setUf(objetoAE[1]);
                aI.setAuxilioMoradia(objetoAE[3]);
                aI.setImovelFuncional(objetoAE[4]);
                
                manager.getTransaction().begin();
                manager.persist(aI);
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
