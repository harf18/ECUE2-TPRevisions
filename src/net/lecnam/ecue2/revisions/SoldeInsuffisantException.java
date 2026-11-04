package net.lecnam.ecue2.revisions;

public class SoldeInsuffisantException extends Exception {

    private double montantManquant;

    // Constructeur avec message
    public SoldeInsuffisantException(String message) {
        super(message);
    }

    // Constructeur avec message et montant manquant
    public SoldeInsuffisantException(String message, double montantManquant) {
        super(message);
        this.montantManquant = montantManquant;
    }

    // Getter
    public double getMontantManquant() {
        return montantManquant;
    }

}