package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {
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
    }

    // Simulation simple d'une méthode de retrait pour tester la levée d'exception
    public static void effectuerRetrait(double solde, double montant) throws SoldeInsuffisantException {
        if (solde < montant) {
            double manque = montant - solde;
            throw new SoldeInsuffisantException("Solde insuffisant pour ce retrait.", manque);
        }
        System.out.println("Retrait effectué avec succès. Nouveau solde : " + (solde - montant) + " €");
    }

    public static void main(String[] args) {
        System.out.println("--- Test 1 : Constructeur simple (message uniquement) ---");
        try {
            throw new SoldeInsuffisantException("Erreur : opération impossible.");
        } catch (SoldeInsuffisantException e) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant : " + e.getMontantManquant() + " €");
        }

        System.out.println("\n--- Test 2 : Constructeur avec montant manquant ---");
        try {
            throw new SoldeInsuffisantException("Solde insuffisant.", 45.50);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Montant manquant : " + e.getMontantManquant() + " €");
        }

        System.out.println("\n--- Test 3 : Simulation d'un retrait bancaire ---");
        double soldeCompte = 100.0;
        double montantSouhaite = 150.0;

        try {
            System.out.println("Tentative de retrait de " + montantSouhaite + " € sur un solde de " + soldeCompte + " €...");
            effectuerRetrait(soldeCompte, montantSouhaite);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Exception capturée !");
            System.out.println("Détail : " + e.getMessage());
            System.out.println("Il vous manque : " + e.getMontantManquant() + " € pour valider le retrait.");
        }
    }
}
