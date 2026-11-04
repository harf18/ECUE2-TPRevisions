package net.lecnam.ecue2.revisions;

public class SoldeInsuffisantException extends Exception{

    String message;
    double manque;

    public SoldeInsuffisantException(String message){
        this.message = message;
    }

    public SoldeInsuffisantException(String message, double manque){
        this.message = message;
        this.manque = manque;
    }

    public double getMontantManquant(){
        return this.manque;
    }

}
