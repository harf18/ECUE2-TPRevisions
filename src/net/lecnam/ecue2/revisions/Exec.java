package net.lecnam.ecue2.revisions;

public class Exec {
    public static void main(String[] args) {

        Client client1 = new Client("pierron", "remi", "01");
        Client client2 = new Client("dupont", "marie", "01"); // même numéro que client1
        Client client3 = new Client("pierron", "remi", "02"); // même nom/prénom, autre numéro

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        System.out.println(client1.getNom() + " " + client1.getPrenom());

        System.out.println(client1.equals(client2)); // true  : même numéro client
        System.out.println(client1.equals(client3)); // false : numéro différent
        System.out.println(client1.equals(null));    // false
        System.out.println(client1.equals("01"));    // false : pas un Client
    }
}