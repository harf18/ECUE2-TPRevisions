package net.lecnam.ecue2.revisions;

public class Exec {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. TEST DE LA CLASSE CLIENT");
        System.out.println("==================================================");

        Client client1 = new Client("BERNARD", "Alice", "C001");
        Client client2 = new Client("BERNARD", "Alice", "C001"); // Mêmes valeurs
        Client client3 = new Client("THOMAS", "Lucas", "C002");   // Numéro différent
        Client client4 = new Client("BERNARD-DUPONT", "Alice", "C001"); // Noms différents mais même numéro

        System.out.println("--- Représentation toString() ---");
        System.out.println(client1);
        System.out.println(client3);

        System.out.println("\n--- Test de la méthode equals() ---");
        System.out.println("client1.equals(client2) [Même N° C001] : " + client1.equals(client2)); // true
        System.out.println("client1.equals(client3) [N° C001 vs C002] : " + client1.equals(client3)); // false
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

        // Instanciation avec découvert personnalisé (200 €)
        CompteCourant cc = new CompteCourant("CC-001", client1, 200.0);
        System.out.println("Compte créé : " + cc);

        // Test 1 : Dépôt valide
        System.out.println("\n--- Dépôt de 100.0 € ---");
        cc.deposer(100.0);
        System.out.println("Nouveau solde : " + cc.getSolde() + " €");

        // Test 2 : Dépôt invalide (IllegalArgumentException)
        System.out.println("\n--- Tentative de dépôt d'un montant négatif (-50.0 €) ---");
        try {
            cc.deposer(-50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception capturée avec succès : " + e.getMessage());
        }

        // Test 3 : Retrait valide autorisé par le découvert (100 € solde - 150 € = -50 €)
        System.out.println("\n--- Retrait de 150.0 € (utilisation du découvert) ---");
        try {
            cc.retirer(150.0);
            System.out.println("Retrait réussi. Nouveau solde : " + cc.getSolde() + " €");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        // Test 4 : Retrait invalide dépassant le découvert autorisé
        // Solde = -50 €, Découvert = 200 € -> Disponible max = 150 €
        // Tentative de retrait = 200 € -> Manque = 50 €
        System.out.println("\n--- Tentative de retrait de 200.0 € (dépassement du découvert) ---");
        try {
            cc.retirer(200.0);
            System.out.println("Retrait effectué.");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Exception capturée !");
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant calculé : " + e.getMontantManquant() + " €");
        }

        // Test 5 : Constructeur avec découvert par défaut (500 €)
        System.out.println("\n--- Test du constructeur avec découvert par défaut (500 €) ---");
        CompteCourant ccDefaut = new CompteCourant("CC-002", client3);
        System.out.println("Découvert autorisé configuré par défaut : " + ccDefaut.getDecouvertAutorise() + " €");
    }
}