package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {

        //testExercice1();
        testExercice4();
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

    private static void testExercice4() {
        Client client1 = new Client("Dujour", "Valentin", "123456A");

        CompteCourant compte1 = new CompteCourant("456789D", client1);

        System.out.println(compte1.toString());

        System.out.println("---------------------");

        compte1.deposer(50);
        System.out.println(compte1.toString());

        System.out.println("---------------------");

        try {
            compte1.retirer(700);
            System.out.println(compte1.toString());

        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------");

        compte1.debiter(500);



    }
}
