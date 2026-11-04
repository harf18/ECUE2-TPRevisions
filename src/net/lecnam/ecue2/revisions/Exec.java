package net.lecnam.ecue2.revisions;

import java.util.ArrayList;
import java.util.List;

public class Exec {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. TEST DE LA CLASSE CLIENT");
        System.out.println("==================================================");

        Client client1 = new Client("BERNARD", "Alice", "C001");
        Client client2 = new Client("BERNARD", "Alice", "C001");
        Client client3 = new Client("THOMAS", "Lucas", "C002");
        Client client4 = new Client("BERNARD-DUPONT", "Alice", "C001");

        System.out.println("--- Représentation toString() ---");
        System.out.println(client1);
        System.out.println(client3);

        System.out.println("\n--- Test de la méthode equals() ---");
        System.out.println("client1.equals(client2) [Même N° C001] : " + client1.equals(client2));
        System.out.println("client1.equals(client3) [N° C001 vs C002] : " + client1.equals(client3));
        System.out.println("client1.equals(client4) [Noms différents mais même N° C001] : " + client1.equals(client4));


        System.out.println("\n==================================================");
        System.out.println("2. TEST DE SoldeInsuffisantException");
        System.out.println("==================================================");

        System.out.println("--- Test 1 : Constructeur simple (message uniquement) ---");
        try {
            throw new SoldeInsuffisantException("Erreur : opération impossible.");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant par défaut : " + e.getMontantManquant() + " €");
        }

        System.out.println("\n--- Test 2 : Constructeur avec montant manquant ---");
        try {
            throw new SoldeInsuffisantException("Solde insuffisant pour la transaction.", 45.50);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant : " + e.getMontantManquant() + " €");
        }


        System.out.println("\n==================================================");
        System.out.println("3. TEST DE LA CLASSE COMPTECOURANT");
        System.out.println("==================================================");

        CompteCourant cc = new CompteCourant("CC-001", client1, 200.0);
        System.out.println("Compte créé : " + cc);

        System.out.println("\n--- Dépôt de 100.0 € ---");
        cc.deposer(100.0);
        System.out.println("Nouveau solde : " + cc.getSolde() + " €");

        System.out.println("\n--- Tentative de dépôt négatif (-50.0 €) ---");
        try {
            cc.deposer(-50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception capturée avec succès : " + e.getMessage());
        }

        System.out.println("\n--- Retrait de 150.0 € (utilisation du découvert) ---");
        try {
            cc.retirer(150.0);
            System.out.println("Retrait réussi. Nouveau solde : " + cc.getSolde() + " €");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        System.out.println("\n--- Tentative de retrait de 200.0 € (dépassement du découvert) ---");
        try {
            cc.retirer(200.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Exception capturée !");
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant calculé : " + e.getMontantManquant() + " €");
        }


        System.out.println("\n==================================================");
        System.out.println("4. TEST DE LA CLASSE COMPTEEPARGNE");
        System.out.println("==================================================");

        // Création d'un compte épargne avec un taux de 3% (0.03)
        CompteEpargne ce = new CompteEpargne("CE-001", client3, 0.03);
        System.out.println("Compte créé : " + ce);

        // Dépôt initial de 1000 €
        System.out.println("\n--- Dépôt initial de 1000.0 € ---");
        ce.deposer(1000.0);
        System.out.println("Solde actuel : " + ce.getSolde() + " €");

        // Retrait valide de 400 €
        System.out.println("\n--- Retrait autorisé de 400.0 € ---");
        try {
            ce.retirer(400.0);
            System.out.println("Retrait réussi. Solde restant : " + ce.getSolde() + " €");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        // Tentative de retrait de 700 € (solde actuel = 600 €, pas de découvert -> manquant = 100 €)
        System.out.println("\n--- Tentative de retrait de 700.0 € (dépassement du solde) ---");
        try {
            ce.retirer(700.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Exception capturée !");
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant calculé : " + e.getMontantManquant() + " €");
        }

        // Test du calcul et de l'application des intérêts (3% sur 600 € = 18 €)
        System.out.println("\n--- Calcul et application des intérêts (Taux : 3%) ---");
        System.out.println("Intérêts calculés : " + ce.calculerInterets() + " €");
        ce.appliquerInterets();
        System.out.println("Nouveau solde après intérêts : " + ce.getSolde() + " €");


        System.out.println("\n==================================================");
        System.out.println("5. TEST DU POLYMORPHISME (LISTE DE COMPTES)");
        System.out.println("==================================================");

        List<CompteBancaire> listeComptes = new ArrayList<>();

        CompteCourant ccPoly = new CompteCourant("CC-002", client1, 300.0);
        ccPoly.deposer(500.0);

        CompteEpargne cePoly = new CompteEpargne("CE-002", client2, 0.05); // Taux 5%
        cePoly.deposer(2000.0);

        listeComptes.add(ccPoly);
        listeComptes.add(cePoly);

        System.out.println("Application des intérêts à l'ensemble des comptes de la banque :");
        for (CompteBancaire compte : listeComptes) {
            double soldeAvant = compte.getSolde();
            compte.appliquerInterets();
            System.out.println("- " + compte.getNumeroCompte() + " | Solde avant : "
                    + soldeAvant + " € | Solde après intérêts : "
                    + compte.getSolde() + " €");
        }
    }
}