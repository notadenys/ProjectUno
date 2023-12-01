package uno.cartes;

import uno.ErreurFichier;
import uno.jeu.Uno;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class PaquetDeCartes implements Iterable<Carte>
{
    private ArrayList<Carte> pdc;

    public PaquetDeCartes()
    {
        pdc = new ArrayList<Carte>();
    }

    public Iterator<Carte> iterator()
    {
        return pdc.iterator();
    }

    public void ajouter(Carte... cartes)
    {
        pdc.addAll(Arrays.asList(cartes));
    }

    public void ajouter(PaquetDeCartes pdc)
    {
        for (int i = 0; i < pdc.getNombreDeCartes(); i++)
        {
            this.pdc.add(pdc.piocher());
        }
    }

    public int getNombreDeCartes()
    {
        return pdc.size();
    }

    public boolean estVide()
    {
        return pdc.isEmpty();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Paquet :");
        for (Carte carte : pdc)
        {
            sb.append(System.lineSeparator()).append(carte.toString());
        }
        return sb.toString();
    }

    public void enlever(Carte carte)
    {
        assert pdc.remove(carte) : "Cette carte n'est pas dans le paquet";
    }

    public Carte getSommet()
    {
        return pdc.get(pdc.size() - 1);
    }

    public Carte piocher()
    {
        assert !estVide() : "Le paquet est vide";
        Carte carte = this.getSommet();
        pdc.remove(getNombreDeCartes() - 1);
        return carte;
    }

    public void melanger()
    {
        Random gen = new Random();
        for (int i = 0; i < getNombreDeCartes(); i++)
        {
            pdc.add(gen.nextInt(getNombreDeCartes()), piocher());
        }
    }

    public int getValeur()
    {
        int sum = 0;
        for (Carte carte : pdc)
        {
            sum += carte.getValeur();
        }
        return sum;
    }

    public void retourner()
    {
        for (int i = getNombreDeCartes(); i > 0; i--)
        {
            pdc.add(getNombreDeCartes()-i, piocher());
        }
    }

    public void ecrire(String nomDeFichier) throws ErreurFichier
    {
        try {

            FileWriter flot = new FileWriter(nomDeFichier) ;
            BufferedWriter flotFiltre = new BufferedWriter(flot) ;
            for(Carte c : pdc)
            {
                flotFiltre.write(c.getNom() + " " + c.getValeur() + " " + c.getCouleur());
                flotFiltre.newLine() ;
            }
            flotFiltre.close() ;
            if (!(new File(nomDeFichier).isFile()))
            {
                throw new ErreurFichier("Error happened while creating the file");
            }
        } catch (IOException e) {System.out.println(e.getMessage());}
    }

    public void lire(String nomDeFichier) throws ErreurFichier
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomDeFichier))){
            String line;
            Uno uno = new Uno();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                String nom = words[0];
                int valeur = Integer.parseInt(words[1]);
                String couleur = words[2];

                switch (nom)
                {
                    case "Chiffre":
                        ajouter(new Chiffre(uno, valeur, Couleur.valueOf(couleur.toUpperCase())));
                        break;
                    case "Plus2":
                        ajouter(new Plus2(uno, Couleur.valueOf(couleur.toUpperCase())));
                        break;
                    case "ChangementDeSens":
                        ajouter(new ChangementDeSens(uno, Couleur.valueOf(couleur.toUpperCase())));
                        break;
                    case "PasseTonTour":
                        ajouter(new PasseTonTour(uno, Couleur.valueOf(couleur.toUpperCase())));
                        break;
                    case "Joker":
                        ajouter(new Joker(uno));
                        break;
                    case "Plus4":
                        ajouter(new Plus4(uno));
                        break;
                }
                if (!(new File(nomDeFichier).isFile())) {
                    throw new ErreurFichier("Error happened while creating the file");
                }
            }
        } catch (IOException e) {System.out.println(e.getMessage());}
    }
}
