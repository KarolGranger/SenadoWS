/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.teste;

import apis.lerXml.ApiSaxLideranca;

/**
 *
 * @author rafael
 */
public class PersisteLideranca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApiSaxLideranca mySax = new ApiSaxLideranca();
        mySax.fazerParsing(".\\src\\java\\arquivos\\liderancas.xml");
        mySax.fazerPersistencia(mySax.getEmpList());
    } 
}