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



}
