package uno.cartes;

import uno.jeu.Uno;

public abstract class Carte {

    private int valeur;
    private Couleur couleur;


    public Carte(Uno uno, int valeur) {
        assert valeur > 0 : "Valeur est non valable";
        this.valeur = valeur;
    }
    
    public Carte(Uno uno, int valeur, Couleur couleur) {
        assert valeur > 0 : "Valeur est non valable";
        this.valeur = valeur;
        assert couleur != null : "Couleur est null";
        this.couleur = couleur;
    }


    public void setValeur(int valeur) {
        assert valeur > 0 : "Valeur est non valable";
        this.valeur = valeur;
    }

    public void setCouleur(Couleur couleur) {
        assert couleur != null : "Couleur est null";
        this.couleur = couleur;
    }

    public int getValeur(){return valeur;}
    public Couleur getCouleur() {
        return couleur;
    }

    public String toString() {
        return getNom()+" {" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }


    public boolean estSansCouleur() {
        return couleur == null;
    }
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return c.couleur == couleur;
    }

    public abstract String getNom();
    public abstract boolean peutEtreRecouvertePar(Carte c);
    public abstract boolean peutEtrePoseeSur(Chiffre c);
    public abstract boolean peutEtrePoseeSur(CarteAction c);
    public abstract boolean peutEtrePoseeSur(CarteSpeciale c);
}
