package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{
    double decouvertAutorise;

    public CompteCourant(String numeroCompte, Client titulaire, double decouvertAutorise){
        super(numeroCompte,titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public CompteCourant(String numeroCompte, Client titulaire){
        this(numeroCompte, titulaire, 500.0);
    }

    public CompteCourant(String numeroCompte, Client titulaire, LocalDate dateOuverture,double solde, double decouvertAutorise){
        super(numeroCompte,titulaire,dateOuverture,solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws SoldeInsuffisantException {
        if (getSolde() - montant < -decouvertAutorise) {
            double manque = montant - (getSolde() + decouvertAutorise);
            throw new SoldeInsuffisantException("découvert autorisé dépassé.", manque);
        }
        debiter(montant);
    }

    @Override
    public double calculerInterets() {
        return 0.0;
    }

    public double getDecouvertAutorise() {return decouvertAutorise;}

}
