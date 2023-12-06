package uno.jeu;

import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

public abstract class Joueur {
    private String nom;
    private PaquetDeCartes main;

    public Joueur(String nom)
    {
        this.nom = nom;

        FabriqueCartes fc = FabriqueCartes.getInstance();
        main = fc.getPaquetVide();
    }

    public PaquetDeCartes getMain()
    {
        return main;
    }

    String getNom()
    {
        return nom;
    }
}
