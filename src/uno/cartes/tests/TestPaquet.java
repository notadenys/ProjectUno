package uno.cartes.tests;

import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

public class TestPaquet {
    public static void main(String[] args)
    {
        testUno();
    }

    public static void testUno()
    {
        FabriqueCartes fc = FabriqueCartes.getInstance();
        PaquetDeCartes pdc = fc.getPaquetUno();
        System.out.println(pdc.toString());
        System.out.println(pdc.getNombreDeCartes());
    }
}
