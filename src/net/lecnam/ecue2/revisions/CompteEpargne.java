package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEpargne extends CompteBancaire{
    double tauxInteret;

    public CompteEpargne(String numeroCompte, Client titulaire, double tauxInteret) {
        super(numeroCompte, titulaire);
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture, double tauxInteret) {
        super(numeroCompte, solde, titulaire, dateOuverture);
        this.tauxInteret = tauxInteret;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant <= getSolde()) {
            debiter(montant);
        } else {
            double montantManquant = montant - getSolde();
            throw new SoldeInsuffisantException("Le montant manquant est de : " + montantManquant);
        }
    }

    public double calculerInterests() {
        return getSolde() * tauxInteret;
    }
}
