package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() throws SoldeInsuffisantException {

        Client cli1 = new Client("Heteur", "Hank", "555777");
        Client cli2 = new Client("Pecteur", "Vince", "333222");
        //System.out.println(cli1.toString());
        CompteCourant cc = new CompteCourant("676767", cli1);
        cc.deposer(6767);
        //cc.deposer(-30);
        //System.out.println(cc.toString());
        //cc.retirer(10000);
        cc.retirer(12);
        //System.out.println(cc.toString());
        CompteEpargne ce = new CompteEpargne("545454", cli1, 0.03);
        ce.deposer(100);
        ce.appliquerInterets();
        //ce.retirer(150);
        ce.retirer(100);
        //System.out.println(ce.toString());
        CompteEntreprise ce2 = new CompteEntreprise("323232", cli1, "Faudra Tiff'Hair", "080055241515619165165");
        ce2.deposer(150000);
        ce2.appliquerInterets();
        //ce2.retirer(14000);
        //System.out.println(ce2.toString());
        CompteCourant cc2 = new CompteCourant("566514", cli2);
        Banque banque = new Banque("BPCE", 5);
        banque.ajouterCompte(cc);
        banque.ajouterCompte(ce);
        banque.ajouterCompte(ce2);
        banque.ajouterCompte(cc2);
        System.out.println(banque.calculerSoldeTotal());
        System.out.println(banque.rechercherCompte("323232").toString());
        System.out.println(banque.listerComptesClient(cli1).length);



    }
}
