package net.lecnam.ecue2.revisions;

public class SoldeInsuffisantException extends Exception {

    double montantManquant;

    /*Constructeur 1*/
    public SoldeInsuffisantException(String message) {
        super(message);
    }

    /*Constructeur 2*/
    public SoldeInsuffisantException(String message, double montantManquant) {
        super(message);
        this.montantManquant = montantManquant;
    }

    public double getMontantManquant() {
        return montantManquant;
    }
}
