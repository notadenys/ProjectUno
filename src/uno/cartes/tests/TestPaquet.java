package uno.cartes.tests;

import uno.ErreurFichier;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;


public class TestPaquet {
    public static void main(String[] args)
    {
        testUno();
        //testLire();
    }

    public static void testUno()
    {
        FabriqueCartes fc = FabriqueCartes.getInstance();
        PaquetDeCartes pdc = fc.getPaquetUno();
        System.out.println(pdc.toString());
        System.out.println(pdc.getNombreDeCartes());
        try {
            pdc.ecrire("cartes.txt");
        }
        catch (ErreurFichier e){System.out.println(e.getMessage());}
        try {
            pdc.lire("cartes.txt");
        }
        catch (ErreurFichier e){System.out.println(e.getMessage());}
    }

    public static void testLire()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        try {
            pdc.lire("cartes.txt");
        }
        catch (ErreurFichier e){System.out.println(e.getMessage());}

        System.out.println(pdc.toString());
        System.out.println(pdc.getNombreDeCartes());
    }
}
