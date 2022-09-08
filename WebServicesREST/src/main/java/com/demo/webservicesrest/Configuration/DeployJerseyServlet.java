package com.demo.webservicesrest.Configuration;

import com.demo.webservicesrest.Compte.CompteRestJaxRS;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeployJerseyServlet {
    //@Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRS.class); /*Lorsque la servlet de jersey démarre, il je lui dis tiens un
        web service qui s'appel CompteRestJaxRS*/
        return jerseyServlet;
    }
    /*Au démarrage jersey servlet scanner les annotations de CompteRestJaxRS,
    * et après il installera les routes, et faire le travail*/
}
