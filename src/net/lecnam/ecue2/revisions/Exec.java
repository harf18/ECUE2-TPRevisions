package net.lecnam.ecue2.revisions;

public class Exec {

    public static void main(String[] args) {

        // Exercice 1
        exercice1();

        // Exercice 2
        exercice2();

    }

    private static void exercice1() {

        Client client1 = new Client("Dupont", "Jean", "001");
        Client client2 = new Client("Martin", "Paul", "002");
        Client client3 = new Client("Durand", "Julie", "001");

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        System.out.println("client1 == client2 : " + client1.equals(client2));
        System.out.println("client1 == client3 : " + client1.equals(client3));
    }

    private static void exercice2() {

        try {
            throw new SoldeInsuffisantException("Solde insuffisant", 50.0);

        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
            System.out.println("Montant manquant : " + e.getMontantManquant());
        }

    }

}