package com.demo.webservicesrest.Compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component /* Comme rest api jax-rs parce que les deux ne font partie dans spring */
@WebService(name = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> comptes() {
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte compte(@WebParam Long id) {
        return compteRepository.findById(id).get();
    }
}
