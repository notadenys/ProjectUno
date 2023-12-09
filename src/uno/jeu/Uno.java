package uno.jeu;

import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

import java.util.ArrayList;

public class Uno {
    private boolean sens;

    private int joueurQuiJoue;
    private int joueurQuiDistribue;

    private ArrayList<Joueur> joueurs;
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;

    public Uno(){}

    public void initialiser(int nbBots)
    {
        sens = true;

        creerLesJoueurs(nbBots);
        choisirQuiDistribue();
        choisirQuiJoue();
        distribuerCartes();
    }

    public void creerLesJoueurs(int nbBots)
    {
        assert nbBots >= 1 : "Pas de bots";
        joueurs = new ArrayList<Joueur>(nbBots + 1);
        joueurs.add(new JoueurHumain(this, "xx"));
        for (int i = 0; i < nbBots; i++)
        {
            joueurs.add(new Bot(this, "Bot " + (i + 1)));
        }
    }

    int getNbJoueurs()
    {
        return joueurs.size();
    }

    int getJoueurQuiDistribue()
    {
        return joueurQuiDistribue;
    }

    PaquetDeCartes getTalon() {return talon;}
    PaquetDeCartes getPioche() { return pioche;}


    public void choisirQuiDistribue() {
        joueurQuiDistribue = (int)(Math.random() * getNbJoueurs());
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = getJoueurQuiDistribue() == getNbJoueurs() ? 0 : getJoueurQuiDistribue() + 1;
    }

    public void distribuerCartes()
    {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetUno();
        pioche.melanger();

        for(Joueur j : joueurs)
        {
            for (int i = 0; i < 7; i++)
            {
                j.getMain().ajouter(pioche.piocher());
            }
        }
        talon.ajouter(pioche.piocher());
    }
}
