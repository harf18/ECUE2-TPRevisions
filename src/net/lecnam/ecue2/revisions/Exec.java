package net.lecnam.ecue2.revisions;

import java.awt.desktop.SystemSleepEvent;

public class Exec {
    public static void main(String[] args) {
        Client client1 = new Client("Grimm", "Eliott", "586423971");
        Client client2 = new Client("Connor", "Sarah", "203602123");
        Client client3 = new Client("Jim", "Eliott", "586423971");


        System.out.println("Exercice 1 test : ");
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client1.equals(client3));
        System.out.println(client2.equals(client3));
        System.out.println("\n");

        System.out.println("Exercice 4 test : ");
        CompteCourant cc1 = new CompteCourant("145236499", client1);
        cc1.deposer(1500);
        System.out.println(cc1);

        try {
            cc1.retirer(500);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(cc1);

        try {
            cc1.retirer(33500);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + "Montant manquant : " + e.getMontantManquant());
        }
        System.out.println(cc1);

        try {
            cc1.deposer(-52);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
