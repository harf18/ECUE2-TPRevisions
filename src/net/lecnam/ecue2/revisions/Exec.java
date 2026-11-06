package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class Exec {
    static void main() throws SoldeInsuffisantException {

        Client client1 = new Client("MOUCHARD", "Yannis", "158jught");
        Client client2 = new Client("LACASA", "Jean", "158jught");
        Client client3 = new Client("ROBERT", "Entier", "488fjegfi");

        System.out.println(client1.toString());
        System.out.println(client1.equals(client2));
        System.out.println(client1.equals(client3));

        CompteCourant compte1 = new CompteCourant("186465163", client1, 1500);

        compte1.deposer(1500);
        compte1.retirer(1000);
        System.out.println(compte1.toString());

        CompteEpargne compte2 = new CompteEpargne("123456789", client2, 0.03);

        compte2.deposer(1500);
        System.out.println(compte2.toString());
    }
}
