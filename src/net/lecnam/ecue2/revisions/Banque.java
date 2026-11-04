package net.lecnam.ecue2.revisions;

public class Banque {

    String nom;
    CompteBancaire[] comptes;
    int nbComptes;

    public Banque(String nom, int capaciteMax){
        this.nom = nom;
        this.comptes = new CompteBancaire[capaciteMax];
        this.nbComptes = 0;
    }

    public void ajouterCompte(CompteBancaire compte){
        for(int i = 0; i < nbComptes; i++){
            if (this.comptes[i].getNumCom().equals(compte.getNumCom())) throw new IllegalArgumentException();
        }
        if (this.comptes[this.comptes.length - 1] != null) throw new IllegalStateException("La banque est pleine");
        this.comptes[this.nbComptes] = compte;
        this.nbComptes ++;
    }

    public int getNbComptes(){
        return nbComptes;
    }

    public CompteBancaire rechercherCompte(String numeroCompte){
        for(int i = 0; i < nbComptes; i++){
            if (this.comptes[i].getNumCom().equals(numeroCompte)) return this.comptes[i];
        }
        return null;
    }

    public CompteBancaire[] listerComptesClient(Client client){
        int nbCapted = 0;
        for(int i = 0; i < nbComptes; i++){
            if (this.comptes[i].getTit().equals(client)) nbCapted ++;
        }
        CompteBancaire[] listComptes = new CompteBancaire[nbCapted];
        nbCapted = 0;
        for(int i = 0; i < nbComptes; i++){
            if (this.comptes[i].getTit().equals(client)) {
                listComptes[nbCapted] = this.comptes[i];
                nbCapted ++;
            }
        }
        return listComptes;
    }

    public double calculerSoldeTotal(){
        double tot = 0;
        for(int i = 0; i < nbComptes; i++){
            tot += comptes[i].getSolde();
        }
        return tot;
    }

}
