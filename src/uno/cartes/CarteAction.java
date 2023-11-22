package uno.cartes;

import uno.jeu.Uno;

/**PasseTonTour, Plus2, ChangementDeSens*/
public abstract class CarteAction extends Carte {
    public CarteAction(Uno uno, Couleur couleur)
    {
        super(uno, 20, couleur);
    }

    public boolean peutEtreRecouvertePar(Carte c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(CarteAction c) {
        return this.getCouleur() == c.getCouleur();
    }

    public boolean peutEtrePoseeSur(CarteSpeciale c) {
        return this.getCouleur() == c.getCouleur();
    }
}
