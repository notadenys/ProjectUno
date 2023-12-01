package tests;

import org.junit.Test;
import uno.ErreurFichier;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;


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


}
