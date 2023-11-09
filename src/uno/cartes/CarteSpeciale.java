package uno.cartes;

import uno.jeu.Uno;

public abstract class CarteSpeciale extends Carte{
    public CarteSpeciale(Uno uno){
        super(uno, 50);
    }


    public boolean peutEtreRecouvertePar(Carte c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        return true;
    }

    public boolean peutEtrePoseeSur(Plus4 c) {
        return false;
    }

    public boolean peutEtrePoseeSur(Plus2 c) {
        return true;
    }

    public boolean peutEtrePoseeSur(Joker c) {
        return false;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }
}
