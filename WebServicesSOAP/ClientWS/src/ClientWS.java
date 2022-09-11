import proxy.BankWS;
import proxy.BanqueService;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubWS = new BankWS().getBanqueServicePort();/*Créer une instance de BanqueService
        à distance*/
        /* Généralement on peut dire qui stubWS est le représentant de web service BanqueService dans l'application ClientWS*/
        System.out.println(stubWS.conversionToDh(16));/*Maintenant on va faire que ce qui on apple
        l'invocation des methods à distance*/
        Compte account = stubWS.getCompte(3L);
        System.out.println(account.getId());
        System.out.println(account.getSolde());
        List<Compte> accounts = stubWS.listComptes();
        accounts.forEach(c->{
            System.out.println("---------------------------");
            System.out.println(c.getId());
            System.out.println(c.getSolde());
            System.out.println("---------------------------");

        });
    }
}
