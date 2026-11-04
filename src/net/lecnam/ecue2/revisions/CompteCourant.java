package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{

    double decouvertAutorise;

    public CompteCourant(String numeroCompte, Client titulaire){
        super(numeroCompte, titulaire);
        this.decouvertAutorise = 500;
    }

    public CompteCourant(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde, double decouvert) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.decouvertAutorise = decouvert;
    }

    public void retirer(double montant) throws SoldeInsuffisantException{
        if (getSolde() - montant >= -decouvertAutorise) debiter(montant);
        else throw new SoldeInsuffisantException("Solde insuffisant", montant - (getSolde() + this.decouvertAutorise));
    }

    public double calculerInterets(){
        return 0;
    }

    public double getDecouvertAutorise(){
        return this.decouvertAutorise;
    }

}
