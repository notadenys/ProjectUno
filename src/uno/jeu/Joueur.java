package uno.jeu;

import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

public abstract class Joueur {
    private String nom;
    private PaquetDeCartes main;
    private Uno uno;

    public Joueur(Uno uno, String nom)
    {
        this.nom = nom;
        this.uno = uno;

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
    Uno getUno() {return uno;}

    abstract void jouer();
}
