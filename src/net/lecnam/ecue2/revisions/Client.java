package net.lecnam.ecue2.revisions;

public class Client {

    String nom, prenom, numeroClient;

    public Client (String nom, String prenom, String numeroClient){
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getNumCli(){
        return this.numeroClient;
    }

    public String toString(){
        return "Numero client : " + this.numeroClient + " \nNom : " + this.nom + "\nPrénom : " + this.prenom;
    }

    public boolean equals(Client c){
        if (c.getClass() == getClass() || c == null) return false;
        if (c.getNumCli() != this.numeroClient) return false;
        return true;
    }

}
