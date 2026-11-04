package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEntreprise extends CompteBancaire{
    private String nomEntreprise;
    private String siret;
    private double plafondRetrait;


    public CompteEntreprise(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, solde, titulaire, dateOuverture);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = plafondRetrait;
    }

    public CompteEntreprise(String numeroCompte, Client titulaire, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, titulaire);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = plafondRetrait;
    }

    public CompteEntreprise(String numeroCompte, Client titulaire, String nomEntreprise, String siret) {
        super(numeroCompte, titulaire);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        plafondRetrait = 10000;
    }

    @Override
    void retirer(double montant) throws SoldeInsuffisantException {
        if (montant > plafondRetrait) {
            throw new IllegalArgumentException("Montant supérieur à la limite de retrait");
        } else if (montant > getSolde()) {
            throw new SoldeInsuffisantException("Solde insuffisant.", montant - getSolde());
        }

        debiter(montant);
    }

    @Override
    double calculerInterets() {
        return getSolde() * 0.01;
    }

    @Override
    public String toString() {
        return String.format("Entreprise : %s. Siret : %s\n%s\nLimite de Retrait : %.2f",
                nomEntreprise, siret, super.toString(), plafondRetrait);
    }
}
