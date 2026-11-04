package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    /**
     * Constructeur pour la création d'un nouveau compte.
     * Le solde initial est positionné à 0.0 et la date d'ouverture à aujourd'hui.
     */
    public CompteBancaire(String numeroCompte, Client titulaire) {
        this(numeroCompte, titulaire, LocalDate.now(), 0.0);
    }

    /**
     * Constructeur pour recréer un compte existant (ex: chargement depuis un fichier).
     */
    public CompteBancaire(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
    }

    // --- GETTERS (Publics, pas de setter pour solde) ---

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    // --- MÉTHODES MÉTIER ---

    /**
     * Ajoute un montant positif au solde du compte.
     *
     * @param montant Le montant à créditer
     * @throws IllegalArgumentException si le montant est <= 0 (exception unchecked)
     */
    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être strictement positif (reçu : " + montant + ").");
        }
        this.solde += montant;
    }

    /*
     * Pourquoi 'protected' et pas 'public' ?
     *
     * Cette méthode effectue un débit direct sans appliquer aucune règle de gestion
     * ni aucune vérification (découvert autorisé, solde suffisant, etc.).
     *
     * - 'protected' limite son accès aux classes filles (et aux classes du même package).
     *   Cela empêche le code externe (comme le main ou d'autres services) de modifier
     *   directement le solde sans passer par les contrôles de sécurité.
     *
     * - Seule la méthode 'retirer()', qui est publique, doit être exposée à l'extérieur.
     *   Chaque classe fille utilisera 'debiter()' en interne uniquement après avoir
     *   validé ses propres conditions métier.
     */
    protected void debiter(double montant) {
        this.solde -= montant;
    }

    /**
     * Méthode abstraite imposant à chaque type de compte de définir sa propre règle de retrait.
     */
    public abstract void retirer(double montant) throws SoldeInsuffisantException;

    /**
     * Calcule le montant des intérêts selon le type de compte.
     */
    public abstract double calculerInterets();

    /*
     * Pourquoi ne pas utiliser deposer() ici ?
     *
     * 1. Un CompteCourant aura un résultat de calculerInterets() égal à 0.0.
     *    Si on appelait deposer(0.0), la méthode lèverait une IllegalArgumentException
     *    car elle refuse les montants <= 0 !
     *
     * 2. L'application des intérêts est un traitement automatique du système,
     *    ce n'est pas un dépôt manuel effectué par un client.
     */
    public void appliquerInterets() {
        double interets = calculerInterets();
        if (interets > 0) {
            this.solde += interets;
        }
    }

    @Override
    public String toString() {
        return "Compte n°" + numeroCompte +
                " | Titulaire : " + titulaire +
                " | Solde : " + solde + " €" +
                " | Date d'ouverture : " + dateOuverture;
    }
}