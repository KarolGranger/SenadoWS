/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.teste;

import apis.lerXml.ApiSaxParlamentar;

/**
 * @author rafael
 */
public class PersisteParlamentar {

    public static void main(String[] args) {

        ApiSaxParlamentar mySax = new ApiSaxParlamentar();

        mySax.fazerParsing(".\\src\\java\\arquivos\\Senadores.xml");
        mySax.fazerPersistencia(mySax.getEmpList());
    }

}
