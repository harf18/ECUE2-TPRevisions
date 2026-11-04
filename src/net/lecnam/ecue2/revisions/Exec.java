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

        System.out.println("\n");

        System.out.println("Exercice 5 test : ");
        CompteEpargne ce1 = new CompteEpargne("7895182939", client2, 0.07);
        ce1.deposer(5000);
        System.out.println(ce1);

        ce1.appliquerInterets();
        System.out.println(ce1);

        try {
            ce1.retirer(3000000);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + "Montant manquant : " + e.getMontantManquant());
        }
        System.out.println("\n");


        System.out.println("Exercice 6 test : ");
        CompteEntreprise cEntreprise1 = new CompteEntreprise("111111111", client1, "Pleiades Corp.", "777777");
        CompteEntreprise cEntreprise2 = new CompteEntreprise("111151111", client1, "Pleiades Industries", "774477");
        cEntreprise1.deposer(15000000);
        System.out.println(cEntreprise1);

        cEntreprise1.appliquerInterets();
        System.out.println(cEntreprise1);

        try {
            //cEntreprise1.retirer(55000);
            //cEntreprise2.retirer(1);
            cEntreprise1.retirer(10000);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + "Montant manquant : " + e.getMontantManquant());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(cEntreprise1);

    }
}
