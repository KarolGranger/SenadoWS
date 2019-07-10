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
import persistencia.Despesas;

/**
 *
 * @author karol
 */
public class LeituraDespesas {

    public void gravar(String arquivoCSV) throws FileNotFoundException, IOException, TransformerConfigurationException, TransformerException {
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Despesas");
        EntityManager manager = factory.createEntityManager();
        String tipoDespesa;
        double valor;
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                Despesas despesas = new Despesas();
                String[] objetoAE = linha.split(csvDivisor);

                despesas.setAno(objetoAE[0]);
                despesas.setMes(objetoAE[1]);
                despesas.setNomeParlamentar(objetoAE[2]);
                if (objetoAE[3].charAt(0) == 'D' || objetoAE[3].charAt(0) == 'S') {
                    tipoDespesa = objetoAE[3].substring(0, objetoAE[3].length());
                } else {
                    tipoDespesa = objetoAE[3].substring(1, objetoAE[3].length() - 1);
                }
                despesas.setTipoDespesa(tipoDespesa);
                despesas.setCnpjCpf(objetoAE[4]);
                despesas.setFornecedor(objetoAE[5]);
                despesas.setData(objetoAE[7]);
                if (objetoAE[9].charAt(0) == '\"') {
                    valor = Double.parseDouble(objetoAE[9].substring(1, objetoAE[9].length() - 1).replace(",", "."));
                } else {
                    valor = Double.parseDouble(objetoAE[9].replace(",", "."));
                }
                
                despesas.setValorReembolsado(valor);
                manager.getTransaction().begin();
                manager.persist(despesas);
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
