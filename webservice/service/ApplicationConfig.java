/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rafae
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webservice.service.AfastadosFacadeREST.class);
        resources.add(webservice.service.ApoioescritorioFacadeREST.class);
        resources.add(webservice.service.AuxilioimoveisFacadeREST.class);
        resources.add(webservice.service.ColegiadoFacadeREST.class);
        resources.add(webservice.service.DespesasFacadeREST.class);
        resources.add(webservice.service.LiderancaFacadeREST.class);
        resources.add(webservice.service.ParlamentarFacadeREST.class);
        resources.add(webservice.service.PartidosFacadeREST.class);
    }
    
}
