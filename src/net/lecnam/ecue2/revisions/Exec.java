package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {

        //testExercice1();
        testExercice2();
    }

    private static void testExercice1() {
        Client client1 = new Client("Dujour", "Valentin", "123456A");
        Client client2 = new Client("Kylian", "Mbappe", "123456A");

        System.out.println(client1.getNom());
        System.out.println(client1.getPrenom());
        System.out.println(client1.getNumeroClient());

        System.out.println("---------------------");

        System.out.println(client2.toString());

        System.out.println("---------------------");

        System.out.println(client1.equals(client2));
    }

    private static void testExercice2() {
        Client client1 = new Client("Dujour", "Valentin", "123456A");
    }
}
