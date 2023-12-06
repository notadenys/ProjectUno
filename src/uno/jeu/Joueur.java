package uno.jeu;

public abstract class Joueur {
    private String nom;

    public Joueur(String nom)
    {
        this.nom = nom;
    }

    String getNom()
    {
        return nom;
    }
}
