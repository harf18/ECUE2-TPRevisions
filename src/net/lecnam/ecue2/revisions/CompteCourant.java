package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{
    double decouvertAutorise;

    public CompteCourant(String numeroCompte, Client titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public CompteCourant(String numeroCompte, Client titulaire) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = 500;
    }

    public CompteCourant(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture, double decouvertAutorise) {
        super(numeroCompte, solde, titulaire, dateOuverture);
        this.decouvertAutorise = decouvertAutorise;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (getSolde() - montant >= -decouvertAutorise) {
            debiter(montant);
        } else {
            throw new SoldeInsuffisantException("Le montant manquant est de : " + (montant - (getSolde() + decouvertAutorise)));        }
    }

    public double calculerInterests() {
        return 0;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}
