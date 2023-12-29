package uno.jeu;

import uno.Erreurs.InvalidCoupExtension;
import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

import java.util.ArrayList;

public class Uno {
    private boolean sens;
    private boolean fin;
    private boolean finJeu;

    private DLC dlc;

    private int joueurQuiJoue;
    private int joueurQuiDistribue;

    private ArrayList<Joueur> joueurs;
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;

    public Uno(){}

    public void jouer()
    {
        try {
            getJoueurCourant().jouer();
        } catch (InvalidCoupExtension e){
            System.out.println(e.getMessage());
        }

        handleFin();
        prochainJouer();
    }

    public void initialiser(int nbBots)
    {
        sens = true;
        fin = false;
        finJeu = false;

        creerLesJoueurs(nbBots);
        choisirQuiDistribue();
        choisirQuiJoue();
        distribuerCartes();

        dlc.reagir();
    }

    public void creerLesJoueurs(int nbBots)
    {
        assert nbBots >= 1 : "Pas de bots";
        joueurs = new ArrayList<>(nbBots + 1);
        joueurs.add(new JoueurHumain(this, "Joueur"));
        for (int i = 0; i < nbBots; i++)
        {
            joueurs.add(new Bot(this, "Bot " + (i + 1)));
        }
    }

    public boolean getFin() {return this.fin;}
    public boolean getFinJeu() {return this.finJeu;}

    public void handleFin()
    {
        if (getJoueurCourant().aMainVide())
        {
            setFin(true);
            handleFinJeu();
        }
    }

    public void handleFinJeu()
    {
        for (int i = 0; i < getNbJoueurs(); i++)
        {
            if (joueurs.get(i).getTotalScore() > 500) {
                finJeu = true;
                joueurQuiJoue = i;
                break;
            }
        }

    }

    public int getNbJoueurs() {return joueurs.size();}
    public int getJoueurQuiDistribue(){return joueurQuiDistribue;}
    public Joueur getJoueurCourant(){return joueurs.get(joueurQuiJoue);}
    public String getNomDeJoueurCourant(){return getJoueurCourant().getNom();}

    public ArrayList<Joueur> getJoueurs() {return joueurs;}
    public PaquetDeCartes getTalon() {return talon;}
    public PaquetDeCartes getPioche() { return pioche;}

    public Carte getTopCarte(){return talon.getSommet();}


    public void choisirQuiDistribue() {
        joueurQuiDistribue = (int)(Math.random() * getNbJoueurs());
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = getJoueurQuiDistribue() == getNbJoueurs()-1 ? 0 : getJoueurQuiDistribue() + 1;
    }

    public void distribuerCartes()
    {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetUno(this);
        pioche.melanger();

        for(Joueur j : joueurs)
        {
            for (int i = 0; i < 7; i++)
            {
                j.getMain().ajouter(pioche.piocher());
            }
        }
        talon.ajouter(pioche.piocher());
        getTopCarte().appliquerEffet();
    }

    public void setDLC(DLC d) {this.dlc = d;}
    public void setFin(boolean b) {this.fin = b;}

    public void inverserSens(){sens = !sens;}

    public void prochainJouer()
    {
        if(!fin) {
            if(sens)
            {
                joueurQuiJoue = (joueurQuiJoue == getNbJoueurs()-1) ? 0 : joueurQuiJoue + 1;
            }
            else
            {
                joueurQuiJoue = (joueurQuiJoue == 0) ? getNbJoueurs()-1 : joueurQuiJoue - 1;
            }
        }
    }
}
