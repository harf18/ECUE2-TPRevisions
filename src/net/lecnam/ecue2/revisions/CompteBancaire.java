package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    /*Constructeur 1*/
    public CompteBancaire(String numeroCompte, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0;
        this.dateOuverture = LocalDate.now();
    }

    /*Constructeur 2 : utile pour re-créer un compte existant*/
    public CompteBancaire(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }

    /*GETTERS*/
    public String getNumeroCompte() { return numeroCompte; }
    public double getSolde() { return solde; }
    public Client getTitulaire() { return titulaire; }
    public LocalDate getDateOuverture() { return dateOuverture; }

    /*DEPOSER*/
    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être strictement positif !");
        }

        this.solde += montant;
    }

    /*DEBITER*/ /*Protected pour éviter l'accès total mais pour garder l'héritage possible*/
    protected void debiter(double montant) {
        this.solde -= montant;
    }

    /*Méthode abstraite qu'il faudra redéfinir dans les différents comptes*/
    public abstract void retirer(double montant) throws SoldeInsuffisantException;
    public abstract double calculerInterets();

    /*Appliquer les intérêts à tous les comptes*/
    public void appliquerInterets() {
        this.solde += calculerInterets();
    }

    @Override
    public String toString() {
        return  numeroCompte + ", " + solde + ", " + titulaire + ", " + dateOuverture;
    }
}