package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    public CompteBancaire (String numeroCompte, Client titulaire){
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = LocalDate.now();
        this.solde = 0;
    }

    public CompteBancaire(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde){
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
    }

    public String getNumCom() {
        return this.numeroCompte;
    }

    public double getSolde() {
        return this.solde;
    }

    public Client getTit() {
        return this.titulaire;
    }

    public LocalDate getDatOuv() {
        return this.dateOuverture;
    }

    public void deposer(double montant){
        if (montant <= 0) throw new IllegalArgumentException();
        else this.solde += montant;
    }

    // On met en protected pour éviter que TOUT le public y accède, on ne souhaite pas que n'importe qui s'en serve
    protected void debiter(double montant){
        this.solde -= montant;
    }

    public abstract void retirer(double montant) throws SoldeInsuffisantException;
    public abstract double calculerInterets();

    public void appliquerInterets(){
        this.solde += calculerInterets();
    }

    public String toString(){
        return "Numero compte : " + this.numeroCompte
                + "\n" + titulaire.toString()
                + "\nDate d'ouverture : " + this.dateOuverture
                + "\nSolde : " + this.solde;
    }

}
