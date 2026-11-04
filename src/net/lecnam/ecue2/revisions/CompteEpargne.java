package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEpargne extends CompteBancaire{

    double tauxInteret;

    public CompteEpargne(String numeroCompte, Client titulaire, double tauxInteret){
        super(numeroCompte, titulaire);
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde, double tauxInteret) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.tauxInteret = tauxInteret;
    }

    public void retirer(double montant) throws SoldeInsuffisantException{
        if (getSolde() - montant >= 0) debiter(montant);
        else throw new SoldeInsuffisantException("Solde insuffisant", getSolde() - montant);
    }

    public double calculerInterets(){
        return getSolde() * tauxInteret;
    }

}
