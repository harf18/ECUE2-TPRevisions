package net.lecnam.ecue2.revisions;

public class Exec {

    public static void main(String[] args) {

        // Création de clients
        Client client1 = new Client("Dupont", "Jean", "001");
        Client client2 = new Client("Martin", "Paul", "002");
        Client client3 = new Client("Durand", "Julie", "001");

        // Affichage des clients
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        // Comparaison des clients
        System.out.println("client1 == client2 : " + client1.equals(client2));
        System.out.println("client1 == client3 : " + client1.equals(client3));
    }

}