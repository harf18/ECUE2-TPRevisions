package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {
    private final String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    public CompteBancaire(String numeroCompte, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        solde = 0;
        dateOuverture = LocalDate.now();
    }

    public CompteBancaire(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
    }

    public void deposer(double montant) {
        if (montant <= 0)
            throw new IllegalArgumentException("Le montant doit être strictement supérieur à 0.");

        solde += montant;
    }

    // Avec protected cette méthode ne sera disponible que dans la class et ses sous class, ce qui permet un meilleur contrôle
    // des montants retirés
    protected void debiter(double montant) {
        solde -= montant;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    abstract void retirer(double montant) throws SoldeInsuffisantException;
    abstract double calculerInterets();

    @Override
    public String toString() {
        return String.format("Compte %s (%s) crée le %s\n" +
                "Solde : %f", numeroCompte, titulaire, dateOuverture, solde);
    }

    void appliquerInterets() {
        solde += calculerInterets();
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
}
