package WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
/*Puisqu'on travaille maintenant sur cette classe on peut utiliser des
* annotations de JaxB pour controller la mapping objet xml (XML<--->objet java) des objets qui sont
* des instances de cette classe */
@XmlRootElement(name = "compte") /* Pour mettre le name de l'élément xml de cette classe*/
@XmlAccessorType(XmlAccessType.FIELD) /*Cette annotation est sur les attributs, et avec la valeur
XmlAccessType.FIELD ça veut dire qui les annotations je les place directement
dans les attributs sinon par défaut il faut le mettre sur les getters et les setters*/
public class Compte {
    private Long id;
    private double solde;
    @XmlTransient /*Pour dire non sérialisé l'élément dateCreation dans le format xml */
    private Date dateCreation;

    public Compte(Long id, double solde, Date dateCreation) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }
    public Compte(){}

    public Long getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
