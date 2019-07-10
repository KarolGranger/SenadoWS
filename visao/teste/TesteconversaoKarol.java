/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.teste;

import apis.lerCsv.LeituraApoioEscritorio;
import apis.lerCsv.LeituraAuxilioImoveis;
import apis.lerCsv.LeituraDespesas;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;

/**
 *
 * @author karol
 */
public class TesteconversaoKarol {
    public static void main(String[] args) throws IOException
    {
        try {
            
            //String arquivoDespesa = ".\\src\\arquivos\\despesas.csv";
            String arquivoDespesa = ".\\src\\java\\arquivos\\2018.csv";
            LeituraDespesas despesa = new LeituraDespesas();
            
            String arquivoAuxilio = ".\\src\\java\\arquivos\\auxilio.csv";
            LeituraAuxilioImoveis auxilio = new LeituraAuxilioImoveis();
            
            String arquivoApoio = ".\\src\\java\\arquivos\\apoio.csv";
            LeituraApoioEscritorio apoio = new LeituraApoioEscritorio();
                   
            //auxilio.gravar(arquivoAuxilio);
            //apoio.gravar(arquivoApoio);
            despesa.gravar(arquivoDespesa);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteconversaoKarol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TesteconversaoKarol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}