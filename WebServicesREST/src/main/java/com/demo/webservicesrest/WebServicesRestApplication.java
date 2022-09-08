package com.demo.webservicesrest;

import com.demo.webservicesrest.Client.Client;
import com.demo.webservicesrest.Client.ClientRepository;
import com.demo.webservicesrest.Compte.Compte;
import com.demo.webservicesrest.Compte.CompteRepository;
import com.demo.webservicesrest.Enum.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class WebServicesRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServicesRestApplication.class, args);
    }
    @Bean /*Pour l'exécuter au démarrage*/
    CommandLineRunner runner(CompteRepository compteRepository, ClientRepository clientRepository){
        return args -> {
            Client client1 = clientRepository.save(new Client(null, "issam", null));
            Client client2 = clientRepository.save(new Client(null, "imad", null));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, client1));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, client2));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, client2));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, client1));
            compteRepository.findAll().forEach(compte->{System.out.println(compte.getSolde());});
        };
    }
}
