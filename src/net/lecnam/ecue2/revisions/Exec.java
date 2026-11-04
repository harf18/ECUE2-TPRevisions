package net.lecnam.ecue2.revisions;

public class Exec {

    // Méthode de test qui simule un retrait (en attendant la classe Compte)
    static void retirer(double solde, double montant) throws SoldeInsuffisantException {
        if (montant > solde) {
            throw new SoldeInsuffisantException("Solde insuffisant", montant - solde);
        }
        System.out.println("Retrait de " + montant + " € effectué");
    }

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

        // Test 1 : constructeur avec message et montant manquant
        try {
            retirer(100, 150);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage() + " : il manque " + e.getMontantManquant() + " €");
        }

        // Test 2 : cas normal, pas d'exception
        try {
            retirer(100, 50);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Ne devrait pas s'afficher");
        }

        // Test 3 : constructeur avec message seul
        SoldeInsuffisantException e2 = new SoldeInsuffisantException("Erreur simple");
        System.out.println(e2.getMessage() + " / montant manquant = " + e2.getMontantManquant());
    }
}