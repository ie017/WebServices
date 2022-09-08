package com.demo.webservicesrest.Compte;

import com.demo.webservicesrest.Enum.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "SoldeAndTypes", types = Compte.class)
public interface CompteProjection2 {
    public double getSolde();
    public TypeCompte getType();
}


/* http://localhost:9091/banque/comptes/1?projection=SoldeAndTypes pour avoir le solde et le type de compte qui il y a l'id 1*/