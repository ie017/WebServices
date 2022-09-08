package com.demo.webservicesrest.Compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component /* Cette notation il faut l'ajouter car Path n'est pas annotation de spring,
et après l'ajouter de Component spring consider Path comme leur notation*/
@Path("/banque") /* Pour déclarer le path qui je veux utiliser pour consulter
le web service*/
public class CompteRestJaxRS {
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }
    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON}) /* Quel que soit le format de la demande de résultat par le client,
    le serveur envoyer la réponse en format JSON seulement*/
    public Compte compte(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }
    @Path("/compte")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/compte/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(@PathParam(value = "id") Long id, Compte compte){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @Path("/compte/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void comptes(@PathParam(value = "id") Long id){
        compteRepository.deleteById(id);
    }
}

/*Jersey servlet implémente JAX-RS qui est un spec(API fournée par java)*/
/*Jersey servlet qui va faire le travail n'est pas dispatcher Servlet*/
/*Il reste maintenant de deployer la servlet Jersey (Consulté le package Configuration)*/