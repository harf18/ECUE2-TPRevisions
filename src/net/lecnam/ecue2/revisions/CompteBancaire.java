package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    public CompteBancaire(String numeroCompte, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = LocalDate.now();
        this.solde = 0;
    }

    public CompteBancaire(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
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

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    public void setDateOuverture(LocalDate dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
        } else {
            throw new IllegalArgumentException("Le montant du dépôt doit être strictement positif.");
        }
    }

    protected void debiter(double montant) {
        this.solde -= montant;
    }
    // Protected permet que celle méthode ne soit que utiliser dans cette classe

    public abstract void retirer(double montant) throws SoldeInsuffisantException;

    public abstract double calculerInterests();

    public void appliquerInterests() {
        this.solde += calculerInterests();
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", titulaire=" + titulaire +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
