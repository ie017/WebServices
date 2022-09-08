package com.demo.webservicesrest.Compte;

import com.demo.webservicesrest.Client.Client;
import com.demo.webservicesrest.Enum.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
/* C'est le format est json le web services utilise l'élément jackson pour converter les objets en format json*/
/* C'est le format est Xml le WS utilise l'élément jaxB pour converter les objets comme Compte au format xml
* et pour cela il faut utiliser l'annotation XmlRootElement*/
@XmlRootElement/*Cette notation est utilisée au moment de l'utilisation de la forme XML pour obtenir les réponses*/

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING) /* EnumType.ORDINAL est la valeur par défaut
    pour avoir les type se forme des nombres */
    private TypeCompte type;
    @ManyToOne
    private Client client;
}
