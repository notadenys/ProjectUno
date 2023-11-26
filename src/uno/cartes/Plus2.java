package uno.cartes;

import uno.jeu.Uno;

public class Plus2 extends CarteAction {
    public Plus2(Uno uno, Couleur couleur)
    {
        super(uno, couleur);
    }

    public String getNom() {
        return "Plus2";
    }
}
