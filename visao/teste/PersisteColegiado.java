/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.teste;

import apis.lerXml.ApiSaxColegiado;

/**
 *
 * @author rafael
 */
public class PersisteColegiado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApiSaxColegiado mySax = new ApiSaxColegiado();
        mySax.fazerParsing(".\\src\\java\\arquivos\\colegiado.xml");
        mySax.fazerPersistencia(mySax.getEmpList());
    }
}
