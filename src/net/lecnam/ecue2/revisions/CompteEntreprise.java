package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEntreprise extends CompteBancaire{

    String nomEntreprise, siret;
    double plafondRetrait;

    public CompteEntreprise(String numeroCompte, Client titulaire, String nomEntreprise, String siret) {
        super(numeroCompte, titulaire);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = 10000;
    }

    public CompteEntreprise(String numeroCompte, Client titulaire, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, titulaire);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = plafondRetrait;
    }

    public CompteEntreprise(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = plafondRetrait;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant > this.plafondRetrait) throw new IllegalArgumentException();
        else if (this.getSolde() < montant) throw new SoldeInsuffisantException("Solde insuffisant", montant - this.getSolde());
        else debiter(montant);
    }

    public double calculerInterets() {
        return getSolde() * 0.01;
    }

    public String toString(){
        return super.toString() +
                "\nNom de l'entreprise : " + this.nomEntreprise +
                "\nSiret : " + this.siret;
    }
}
