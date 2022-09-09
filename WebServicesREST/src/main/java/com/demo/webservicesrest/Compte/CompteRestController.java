package com.demo.webservicesrest.Compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* RestController basé sur dispatcher Servlet, c'est-à-dire il est basé sur MVC et pour ça il faut le désactiver de Jersey servlet*/

/* Avant d'utiliser RestController il faut désactiver la servlet de Jersey,
et pour cela on peut désactiver la notation Bean dans la classe DeployJerseyServlet*/

/* On peut ajouter qui RestController est le plus fiable Rest API dans ce cas, car nous avons dans l'écosystème de spring, et le standard
* dans jee est jax-rs*/

@RestController
@RequestMapping(path = "/banque")
public class CompteRestController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Compte> comptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/compte/{id}")
    public Compte compte(@PathVariable(value = "id") Long id) {
        return compteRepository.findById(id).get();
    }

    @PostMapping("/compte")
    public Compte save(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/compte/{id}")
    public Compte update(@PathVariable(value = "id") Long id, Compte compte) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/compte/{id}")
    public void comptes(@PathVariable(value = "id") Long id) {
        compteRepository.deleteById(id);
    }
}
