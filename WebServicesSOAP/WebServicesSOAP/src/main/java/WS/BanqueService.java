package WS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "BankWS")
public class BanqueService {
    @WebMethod(operationName = "ConversionToDh")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*10.5;
    }
    @WebMethod /* Sans operationName alors il prendra le meme nom de la methode */
    public Compte getCompte(@WebParam(name = "id" /* Sans spécification de le name, @WebParam ne
      prendra pas le meme name de parameter*/) Long id){
        return new Compte(id, Math.random()*15000, new Date());
    }
    @WebMethod
    public List<Compte> listComptes(){
        List<Compte> comptes = new ArrayList<>();
        comptes.add(new Compte(1L, Math.random()*15000, new Date()));
        comptes.add(new Compte(2L, Math.random()*15000, new Date()));
        comptes.add(new Compte(3L, Math.random()*15000, new Date()));
        return comptes;
    }
}

/* Il faut maintenant de déployer ce web services, et pour ça il faut le créer un class java
* ServeurJaxWS qui present le serveur qui déployer ce WS*/