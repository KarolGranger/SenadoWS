/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.teste;

import apis.lerXml.ApiSaxPartido;

/**
 *
 * @author rafael
 */
public class PersistePartidos {

    public static void main(String[] args) {
        ApiSaxPartido mySax = new ApiSaxPartido();
        mySax.fazerParsing(".\\src\\java\\arquivos\\partidos.xml");
        mySax.fazerPersistencia(mySax.getEmpList());
    }
}