package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() throws SoldeInsuffisantException {

        Client cli1 = new Client("Heteur", "Hank", "555777");
        //System.out.println(cli1.toString());
        CompteCourant cc = new CompteCourant("676767", cli1);
        cc.deposer(6767);
        //cc.deposer(-30);
        //System.out.println(cc.toString());
        //cc.retirer(10000);
        cc.retirer(12);
        //System.out.println(cc.toString());
        CompteEpargne ce = new CompteEpargne("676767", cli1, 0.03);
        ce.deposer(100);
        ce.appliquerInterets();
        //ce.retirer(150);
        ce.retirer(100);
        //System.out.println(ce.toString());
        CompteEntreprise ce2 = new CompteEntreprise("676767", cli1, "Faudra Tiff'Hair", "080055241515619165165");
        ce2.deposer(150000);
        ce2.appliquerInterets();
        //ce2.retirer(14000);
        System.out.println(ce2.toString());

    }
}
