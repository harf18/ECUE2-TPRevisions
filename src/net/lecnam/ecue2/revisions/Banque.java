package net.lecnam.ecue2.revisions;

import java.util.Arrays;

public class Banque {
    private String nom;
    private CompteBancaire[] comptes;
    private int nbComptes;

    public Banque(String nom, int capaciteMax) {
        this.nom = nom;
        comptes = new CompteBancaire[capaciteMax];
        nbComptes = 0;
    }

    public void ajouterCompte(CompteBancaire compte)
    {
        if (compte == null) return;
        if (comptes.length == nbComptes) {
            throw new IllegalStateException("La banque est pleine");
        }

        for (int i =0; i < nbComptes;i++) {
            if (comptes[i].getNumeroCompte().equals(compte.getNumeroCompte())) {
                throw new IllegalArgumentException("Compte avec ce numéro déjà enregistré");
            }
        }

        comptes[nbComptes] = compte;
        nbComptes++;
    }

    public CompteBancaire rechercherCompte(String numeroCompte) {
        for (int i =0; i < nbComptes;i++) {
            if (comptes[i].getNumeroCompte().equals(numeroCompte)) {
                return comptes[i];
            }
        }
        return null;
    }

    public CompteBancaire[] listerComptesClient(Client client) {
        int nbComptesClient = 0;
        CompteBancaire[] tempComptesClient = new CompteBancaire[nbComptes];

        for (int i =0; i < nbComptes;i++) {
            if (comptes[i].getTitulaire().equals(client)) {
                tempComptesClient[nbComptesClient] = comptes[i];
                nbComptesClient++;
            }
        }

        return Arrays.copyOf(tempComptesClient, nbComptesClient);
    }

    public double calculerSoldeTotal()
    {
        double soldeTotal = 0;
        for (int i =0; i < nbComptes;i++) {
            soldeTotal += comptes[i].getSolde();
        }
        return soldeTotal;
    }

    public int getNbComptes() {
        return nbComptes;
    }
}
