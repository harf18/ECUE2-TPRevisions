package net.lecnam.ecue2.revisions;

import java.util.Objects;

public class Client {

    String nom;
    String prenom;
    String numeroClient;

    /*Constructeur*/
    public Client(String nom, String prenom, String numeroClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    @Override
    public String toString() {
        return nom + ", " +prenom + ", " +numeroClient;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(numeroClient, client.numeroClient);
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
}
