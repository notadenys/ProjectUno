package uno.cartes;

import uno.jeu.Uno;

public class Plus2 extends Carte {
    public Plus2(Uno uno, Couleur couleur)
    {
        super(uno, 20, couleur);
    }


    public boolean peutEtreRecouvertePar(Carte c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        return this.getCouleur() == c.getCouleur();
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
