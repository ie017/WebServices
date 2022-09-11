import WS.BanqueService;

import javax.xml.ws.Endpoint;

public class ServeurJaxWS {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:9091/";
        /*si vous mettez localhost dans l'url alors les @ qui sont dans la meme carte reseau
        * qui ont l'autorisation d'accès a ce WS, mais le WS est déployé pour avoir des accès a distance
        * et por cela on va utiliser 0.0.0.0 c'est-à-dire l'accès via import quelle interface*/
        /* url est le lien qui permet d'accès à notre WS BanqueService via le port 9091*/
        Endpoint.publish(url, new BanqueService());
        System.out.println(url);

    }
    /* Pour l'accès a WSDL qui define les operations et les methods de notre service il faut consulter
    * le lien suivant : http://localhost:9091/BankWS?wsdl, et dans portType (est l'interface de WS) dans
    *  le format XML on trouve toutes les opérations avec leurs entées et sorties*/

    /* Utilisé SOAPUI pour tester les web services*/

    /* Pour fait le mapping objet xml, c'est-à-dire converter un objet java au format xml ou le contraire on peut
     utiliser une libraries qui s'appelle jaxB et qui integer dans java 8, mais à partir java 9 il faut l'ajouter */

    /* JaxWS fait l'appelle à jaxB automatiquement dans ce travail, et pour ça on trouve que l'objet compte converter
    * au format xml dans la response de get compte (SOAP response)*/
}
