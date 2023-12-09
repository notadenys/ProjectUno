package uno.jeu;

import uno.cartes.Carte;

public class Bot extends Joueur{
    public Bot(Uno uno, String nom)
    {
        super(uno, nom);
    }

    public void jouer()
    {
        Carte top_carte = getUno().getTalon().getSommet();

        // iterate through the bot's deck to find a suitable card
        for (Carte carte : getMain())
        {
            if (top_carte.peutEtreRecouvertePar(carte))
            {
                // if the card doesn't have a color we generate a random color for it
                if (carte.estSansCouleur())
                {
                    carte.setRandomColeur();
                }
                getUno().getTalon().ajouter(carte);
                getMain().enlever(carte);
                return;  // quit the function
            }
        }
        // if not found draw a card from the deck
        getMain().ajouter(getUno().getPioche().piocher());
        if (top_carte.peutEtreRecouvertePar(getMain().getSommet()))
        {
            // if the card doesn't have a color we generate a random color for it
            if (getMain().getSommet().estSansCouleur())
            {
                getMain().getSommet().setRandomColeur();
            }
            getUno().getTalon().ajouter(getMain().piocher());
        }
    }
}
