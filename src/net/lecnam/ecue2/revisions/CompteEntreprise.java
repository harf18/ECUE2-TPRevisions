package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteEntreprise extends CompteBancaire{
    String nomEntreprise;
    String siret;
    double plafondRetrait;

    public CompteEntreprise(String numeroCompte, Client titulaire, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, titulaire);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = 10000;
    }

    public CompteEntreprise(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture, String nomEntreprise, String siret, double plafondRetrait) {
        super(numeroCompte, solde, titulaire, dateOuverture);
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.plafondRetrait = plafondRetrait;
    }

    // On utilise IllegalArgumentException car on ne devrait jamais avoir se cas alors que on utilise SoldeInsuffisantException car tout dépend des actions du compte
    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant < this.plafondRetrait) {
            if (montant < getSolde()) {
                debiter(montant);
            } else {
                double montantManquant = montant - getSolde();
                throw new SoldeInsuffisantException("Le montant manquant est de : " + montantManquant);
            }
        } else {
            throw new IllegalArgumentException("Le montant dépasse le plafond de retrait");
        }
    }

    public double calculerInterests() {
        return getSolde() * 0.01;
    }

    @Override
    public String toString() {
        return "CompteEntreprise{" +
                super.toString() +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                ", siret='" + siret + '\'' +
                ", plafondRetrait=" + plafondRetrait +
                '}';
    }
}
