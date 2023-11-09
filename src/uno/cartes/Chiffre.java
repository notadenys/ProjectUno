package uno.cartes;

import uno.jeu.Uno;

public class Chiffre extends Carte{
    public Chiffre(Uno uno, int valeur, Couleur couleur)
    {
        super(uno, valeur, couleur);
    }

    public boolean peutEtreRecouvertePar(Carte c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        return this.getValeur() == c.getValeur() || this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(Plus2 c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(Plus4 c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(Joker c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return this.getCouleur() == c.getCouleur();
    }
}
