package net.lecnam.ecue2.revisions;

public class Client {
    String nom;
    String prenom;
    String numeroClient;

    public Client(String nom, String prenom, String numeroClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroClient='" + numeroClient + '\'' +
                '}';
    }

    public boolean equals(Client o) {
        if (numeroClient == o.numeroClient) {
            return true;
        } else {
            return false;
        }
    }
}
