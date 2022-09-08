package com.demo.webservicesrest.Compte;

import org.springframework.data.rest.core.config.Projection;

/* Pour specifier les attributes demander, c'est-à-dire faire comme l'opération de maps avec le développeur backend, et comme graph ql avec le frontend,
* on peut utiliser cette classe-là */
@Projection(name = "Solde", types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}
 /* http://localhost:9091/banque/comptes/1?projection=Solde pour avoir le solde seulement de compte avec l'id égale 1*/