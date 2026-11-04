package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire {

    private static final double DECOUVERT_PAR_DEFAUT = 500;

    private double decouvertAutorise;

    // Numéro, titulaire et découvert autorisé
    public CompteCourant(String numeroCompte, Client titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Découvert par défaut de 500 €
    public CompteCourant(String numeroCompte, Client titulaire) {
        this(numeroCompte, titulaire, DECOUVERT_PAR_DEFAUT);
    }

    // Constructeur complet (exercice 11 : chargement depuis un fichier)
    public CompteCourant(String numeroCompte, Client titulaire, LocalDate dateOuverture,
                         double solde, double decouvertAutorise) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws SoldeInsuffisantException {
        if (getSolde() - montant >= -decouvertAutorise) {
            debiter(montant);
        } else {
            double manquant = montant - (getSolde() + decouvertAutorise);
            throw new SoldeInsuffisantException("Solde insuffisant sur le compte " + getNumeroCompte(), manquant);
        }
    }

    // Un compte courant ne rapporte pas d'intérêts
    @Override
    public double calculerInterets() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [courant, decouvert autorise=" + decouvertAutorise + "]";
    }
}