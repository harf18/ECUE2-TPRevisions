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
        System.out.println(cc.toString());

    }
}
