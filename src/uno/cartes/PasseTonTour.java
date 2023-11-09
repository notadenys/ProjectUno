package uno.cartes;

import uno.jeu.Uno;

public class PasseTonTour extends CarteAction {
    public PasseTonTour(Uno uno, Couleur couleur)
    {
        super(uno, couleur);
    }

    public String getNom() {
        return "Passe Ton Tour";
    }
}
