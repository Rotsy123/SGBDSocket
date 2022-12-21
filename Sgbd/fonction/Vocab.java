package fonction;

import java.util.ArrayList;


import table.*;

public class Vocab {

    public Table Vocabulaire(String requete) throws Exception {
        Table t = new Table();
        Vocabulaire vocabulaire = new Vocabulaire();
        ArrayList<String> req = vocabulaire.split(requete);
        if (req.get(0).equalsIgnoreCase("select")) {
            t = vocabulaire.checkSelect(requete);
        }
        if (req.get(0).equalsIgnoreCase("unir")) {
            t = vocabulaire.unir(requete);
        }
        if (req.get(0).equalsIgnoreCase("projeter")) {
            t = vocabulaire.projection(requete);
        }
        if (req.get(0).equalsIgnoreCase("intersection")) {
            t = vocabulaire.intersection(requete);
        }
        if (req.get(0).equalsIgnoreCase("difference")) {
            t = vocabulaire.difference(requete);
        }
        if (req.get(0).equalsIgnoreCase("produit")) {
            t = vocabulaire.produitCartesien(requete);
        }
        return t;
    }

    public String RenvoiReponse(Table t) {
        String reponse = "";
        for (int i = 0; i < t.getAttributs().size(); i++) {
            reponse = reponse + t.getAttributs().get(i) + "----------------------------------------";
        }
        reponse = reponse + "\n";
        for (int k = 0; k < t.getDonnees().size(); k++) {
            for (int j = 0; j < t.getDonnees().get(k).size(); j++) {
                reponse = reponse + t.getDonnees().get(k).get(j) + "-------------------------------";
            }
            reponse = reponse + "\n";
        }

        return reponse;
    }
}