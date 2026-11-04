package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    // Nouveau compte : date du jour, solde à 0
    public CompteBancaire(String numeroCompte, Client titulaire) {
        this(numeroCompte, titulaire, LocalDate.now(), 0);
    }

    // Compte existant (utilisé pour le chargement depuis un fichier, exercice 11)
    public CompteBancaire(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    // Pas de setSolde() : le solde ne doit changer que par deposer(), debiter() ou appliquerInterets()

    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être strictement positif");
        }
        solde += montant;
    }

    protected void debiter(double montant) {
        solde -= montant;
    }

    // Chaque type de compte a ses propres règles de retrait
    public abstract void retirer(double montant) throws SoldeInsuffisantException;

    public abstract double calculerInterets();


    public void appliquerInterets() {
        solde += calculerInterets();
    }

    @Override
    public String toString() {
        return "Compte(numero=" + numeroCompte +
                ", titulaire=" + titulaire +
                ", solde=" + solde +
                ", date ouverture=" + dateOuverture + ")";
    }
}