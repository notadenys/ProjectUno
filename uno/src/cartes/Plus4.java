package src.cartes;

import src.jeu.Uno;

public class Plus4 extends CarteSpeciale {
    public Plus4(Uno uno){
        super(uno);
    }

    public String getNom() {
        return "Plus4";
    }

    public boolean estSansEffet(){return false;}

    @Override
    public void appliquerEffet() {
        getUno().prochainJouer();

        getUno().getJoueurCourant().piocher();
        getUno().getJoueurCourant().piocher();
        getUno().getJoueurCourant().piocher();
        getUno().getJoueurCourant().piocher();

        System.out.println(getUno().getNomDeJoueurCourant() + " prends 4 cartes et passes son tour");
    }
}
