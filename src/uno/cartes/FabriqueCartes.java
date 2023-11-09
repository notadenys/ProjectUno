package uno.cartes;

import uno.jeu.Uno;

public class FabriqueCartes {
    private static FabriqueCartes instance = new FabriqueCartes();

    public static FabriqueCartes getInstance() {return instance;}

    private FabriqueCartes(){}

    public PaquetDeCartes getPaquetUno()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        Uno uno = new Uno();
        for (Couleur col : Couleur.values())
        {
            pdc.ajouter(new Chiffre(uno, 0, col));
            for (int i = 1; i < 10; i++)
            {
                pdc.ajouter(new Chiffre(uno, i, col));
                pdc.ajouter(new Chiffre(uno, i, col));
            }

            pdc.ajouter(new Plus2(uno, col));
            pdc.ajouter(new Plus2(uno, col));

            pdc.ajouter(new PasseTonTour(uno, col));
            pdc.ajouter(new PasseTonTour(uno, col));

            pdc.ajouter(new ChangementDeSens(uno, col));
            pdc.ajouter(new ChangementDeSens(uno, col));

            pdc.ajouter(new Plus4(uno));
            pdc.ajouter(new Joker(uno));
        }
        return pdc;
    }
}
