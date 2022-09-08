package com.demo.webservicesrest.Compte;

import com.demo.webservicesrest.Enum.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/* Pour utiliser Spring data Rest tout simplement
 il se fait d'ajouter la notation */

/*Désactiver tout les rest api pour utiliser ce rest */

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    //@RestResource(path = "/byType") pour remplacer le nome de la methode findByType dans le lien par byType
    public List<Compte> findByType(/*@Param("type") pour remplacer typeCompte dans le lien par type*/ TypeCompte typeCompte); /* Il est possible d'utiliser cette méthode dans le rest spring data rest, et
    pour ça par exemple on consultera le lien : http://localhost:9091/banque/comptes/search/findByType?typeCompte=COURANT*/
}
