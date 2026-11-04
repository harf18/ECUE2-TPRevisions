package net.lecnam.ecue2.revisions;

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


    }
}
