package uno.cartes;


public enum Couleur {
    BLEU("Bleu"),
    ROUGE("Rouge"), 
    VERT("Vert"), 
    JAUNE("Jaune");

    private String nom;

    private Couleur(String nom)
    {
        assert nom != null : "Nom est vide";
        this.nom = nom;
    }

    public String getNom()
    {
        return nom;
    }

    public String toString()
    {
        return nom;
    }
}
