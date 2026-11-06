package net.lecnam.ecue2.revisions;

public class SoldeInsuffisantException extends Exception{

    String message;
    double montant;

    public SoldeInsuffisantException(String message) {
        this.message = message;
    }

    public SoldeInsuffisantException(String message, double montant) {
        this.message = message;
        this.montant = montant;
    }

    public double getMontantManquant() {
        return montant;
    }
}
