package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{

    private double decouvertAutorise; /*Montant du découvert autorisé*/

    /*Constructeur 1*/
    public CompteCourant(String numeroCompte, Client titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    /*Constructeur 2*/
    public CompteCourant(String numeroCompte, Client titulaire) {
        this(numeroCompte, titulaire, 500.0);
    }

    /*Constructeur 3*/
    public CompteCourant(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde, double decouvertAutorise) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws SoldeInsuffisantException {
        if (getSolde() - montant >=  -this.decouvertAutorise) {
            debiter(montant);
        } else {
            double montant_manquant = montant - (getSolde() + this.decouvertAutorise);
            throw new SoldeInsuffisantException("Il vous manque " + montant_manquant + "€ sur votre compte pour retirer");
        }
    }

    @Override
    public double calculerInterets() {
        return 0.0;
    }

    /*GETTER*/
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}
