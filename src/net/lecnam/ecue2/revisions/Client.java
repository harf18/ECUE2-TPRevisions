package net.lecnam.ecue2.revisions;

public class Client {

    private String nom;
    private String prenom;
    private String numeroClient;

    // Constructeur
    public Client(String nom, String prenom, String numeroClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    // toString()
    @Override
    public String toString() {
        return "Client : " + prenom + " " + nom
                + " (Numéro client : " + numeroClient + ")";
    }

    // equals()
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Client autre = (Client) obj;

        return numeroClient.equals(autre.numeroClient);
    }

}