package uno.cartes;

import uno.jeu.Uno;

public class ChangementDeSens extends CarteAction {
    public ChangementDeSens(Uno uno, Couleur couleur)
    {
        super(uno, couleur);
    }

    public String getNom() {
        return "Changement De Sens";
    }
}
