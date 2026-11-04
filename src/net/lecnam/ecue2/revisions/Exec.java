package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class Exec {

    public static void main(String[] args) {

        // ===== Exercice 1 : Client =====
        System.out.println("=== Tests Client ===");

        Client client1 = new Client("pierron", "remi", "01");
        Client client2 = new Client("dupont", "marie", "01"); // même numéro que client1
        Client client3 = new Client("pierron", "remi", "02"); // même nom/prénom, autre numéro

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        System.out.println(client1.getNom() + " " + client1.getPrenom() + " (" + client1.getNumeroClient() + ")");

        System.out.println(client1.equals(client2)); // true  : même numéro client
        System.out.println(client1.equals(client3)); // false : numéro différent
        System.out.println(client1.equals(null));    // false
        System.out.println(client1.equals("01"));    // false : pas un Client

        // ===== Exercice 2 : SoldeInsuffisantException =====
        System.out.println();
        System.out.println("=== Tests SoldeInsuffisantException ===");

        // Constructeur avec message seul : montant manquant à 0 par défaut
        SoldeInsuffisantException e1 = new SoldeInsuffisantException("Erreur simple");
        System.out.println(e1.getMessage() + " / montant manquant = " + e1.getMontantManquant()); // 0.0

        // Constructeur avec message et montant manquant
        SoldeInsuffisantException e2 = new SoldeInsuffisantException("Erreur avec montant", 42.5);
        System.out.println(e2.getMessage() + " / montant manquant = " + e2.getMontantManquant()); // 42.5

        // ===== Exercice 3 et 4 : CompteBancaire / CompteCourant =====
        System.out.println();
        System.out.println("=== Tests CompteCourant ===");

        Client jean = new Client("Dupont", "Jean", "C123");

        // Découvert par défaut : 500
        CompteCourant cc = new CompteCourant("CC001", jean);
        System.out.println(cc);
        System.out.println("Découvert autorisé : " + cc.getDecouvertAutorise()); // 500.0
        System.out.println("Solde initial : " + cc.getSolde());                  // 0.0

        // Dépôt valide
        cc.deposer(100);
        System.out.println("Solde après dépôt de 100 : " + cc.getSolde());       // 100.0

        // Dépôt invalide (montant négatif) : IllegalArgumentException (unchecked)
        try {
            cc.deposer(-10);
            System.out.println("Ne devrait pas s'afficher");
        } catch (IllegalArgumentException e) {
            System.out.println("Dépôt refusé : " + e.getMessage());
        }

        // Retrait valide utilisant le découvert, puis retrait refusé
        try {
            cc.retirer(300); // solde -> -200, autorisé
            System.out.println("Solde après retrait de 300 : " + cc.getSolde()); // -200.0

            cc.retirer(400); // -600 < -500, refusé
            System.out.println("Ne devrait pas s'afficher");
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + " : il manque " + e.getMontantManquant() + " €"); // 100.0
        }
        System.out.println("Solde après retrait refusé : " + cc.getSolde()); // -200.0 (inchangé)

        // Un compte courant ne rapporte pas d'intérêts
        System.out.println("Intérêts : " + cc.calculerInterets()); // 0.0
        cc.appliquerInterets();
        System.out.println("Solde après intérêts : " + cc.getSolde()); // -200.0

        // Découvert personnalisé
        CompteCourant cc2 = new CompteCourant("CC002", jean, 1000);
        System.out.println("Découvert autorisé : " + cc2.getDecouvertAutorise()); // 1000.0
        try {
            cc2.retirer(1000); // solde -> -1000, pile à la limite : autorisé
            System.out.println("Solde après retrait de 1000 : " + cc2.getSolde()); // -1000.0
            cc2.retirer(1);    // -1001 < -1000, refusé
            System.out.println("Ne devrait pas s'afficher");
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + " : il manque " + e.getMontantManquant() + " €"); // 1.0
        }

        // Constructeur complet + polymorphisme (variable de type CompteBancaire)
        CompteBancaire compte = new CompteCourant("CC003", jean, LocalDate.of(2024, 1, 15), 1500.5, 500);
        System.out.println(compte);
        System.out.println("Date d'ouverture : " + compte.getDateOuverture()); // 2024-01-15
        System.out.println("Solde : " + compte.getSolde());                    // 1500.5
        System.out.println("Titulaire : " + compte.getTitulaire().getNom());   // Dupont
    }
}