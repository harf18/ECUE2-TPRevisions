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
}
