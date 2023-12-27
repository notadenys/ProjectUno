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

    public String getNom()
    {
        return nom;
    }
    public Uno getUno() {return uno;}

    public boolean aMainVide() {return main.estVide();}

    public void afficherRes()
    {
        System.out.println(getNom() + " : " + getMain().getValeur());
    }

    abstract void jouer();
}
