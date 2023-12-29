package uno.cartes;

import uno.jeu.Uno;

public class Joker extends CarteSpeciale {
    public Joker(Uno uno){
        super(uno);
    }

    public String getNom() {
        return "Joker";
    }

    public boolean estSansEffet(){return true;}
    public void appliquerEffet(){}
}
