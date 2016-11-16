/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author aluno
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
        resources.add(ws.service.ClienteFacadeREST.class);
        resources.add(ws.service.FornecedorFacadeREST.class);
        resources.add(ws.service.FuncionarioFacadeREST.class);
        resources.add(ws.service.LojaFacadeREST.class);
        resources.add(ws.service.PessoaFacadeREST.class);
        resources.add(ws.service.PessoalojaFacadeREST.class);
        resources.add(ws.service.UsuarioFacadeREST.class);
    }
    
}
