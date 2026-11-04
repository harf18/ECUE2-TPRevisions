package net.lecnam.ecue2.revisions;

import java.util.Objects;

public class Client {
    private String nom;
    private String prenom;
    private String numeroClient;

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
        return String.format("Client %s : %s %s", numeroClient, prenom, nom);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return numeroClient.equals(client.getNumeroClient());
    }

}
