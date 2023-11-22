package uno.cartes;

import uno.jeu.Uno;

public class Chiffre extends Carte{
    public Chiffre(Uno uno, int valeur, Couleur couleur)
    {
        super(uno, valeur, couleur);
    }


    public String getNom() {
        return "Chiffre";
    }

    public boolean peutEtreRecouvertePar(Carte c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        return this.getValeur() == c.getValeur() || this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(CarteSpeciale c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(CarteAction c) {
        return this.getCouleur() == c.getCouleur();
    }
}
