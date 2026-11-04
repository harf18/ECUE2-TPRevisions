package net.lecnam.ecue2.revisions;

import java.util.Objects;

public class Client {
    String nom;
    String prenom;
    String numeroClient;

    public Client(String nom, String prenom,String numeroClient){
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    public String getNom(){return nom;}

    public String getPrenom(){return prenom;}

    public String getNumeroClient(){return numeroClient;}

    @Override
    public String toString() {
        return "Client [N°=" + numeroClient + ", Nom=" + nom + ", Prénom=" + prenom + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        return Objects.equals(this.numeroClient, other.numeroClient);
    }
}
