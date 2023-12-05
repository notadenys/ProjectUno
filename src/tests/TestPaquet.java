package tests;

import org.junit.Test;
import uno.ErreurFichier;
import uno.cartes.*;
import uno.jeu.Uno;

import java.sql.SQLOutput;


public class TestPaquet {
    @Test
    public void testUno()
    {
        FabriqueCartes fc = FabriqueCartes.getInstance();
        PaquetDeCartes pdc = fc.getPaquetUno();
        System.out.println(pdc.toString());
        System.out.println(pdc.getNombreDeCartes());
        try {
            pdc.ecrire("cartes.txt");
        }
        catch (ErreurFichier e){System.out.println(e.getMessage());}
    }

    @Test
    public void testLire()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        try {
            pdc.lire("cartes.txt");
        }
        catch (ErreurFichier e){System.out.println(e.getMessage());}

        System.out.println(pdc.toString());
        System.out.println(pdc.getNombreDeCartes());
    }

    @Test
    public void testIterator()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        Uno uno = new Uno();
        pdc.ajouter(new Joker(uno), new Plus4(uno));
        for (Carte c : pdc)
        {
            System.out.println(c.toString());
        }
    }
}
