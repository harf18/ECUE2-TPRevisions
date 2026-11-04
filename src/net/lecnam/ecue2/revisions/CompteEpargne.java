package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture, double tauxInteret) {
        super(numeroCompte, solde, titulaire, dateOuverture);
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne(String numeroCompte, Client titulaire, double tauxInteret) {
        super(numeroCompte, titulaire);
        this.tauxInteret = tauxInteret;
    }

    @Override
    void retirer(double montant) throws SoldeInsuffisantException {
        if (montant <= getSolde()) {
            debiter(montant);
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant.", montant - getSolde());
        }
    }

    @Override
    double calculerInterets() {
        return tauxInteret * getSolde();
    }
}
