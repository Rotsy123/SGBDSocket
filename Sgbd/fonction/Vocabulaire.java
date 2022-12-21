package fonction;

import java.util.ArrayList;

import table.*;

public class Vocabulaire {
    Fonction f = new Fonction();
    Create c = new Create();

    public ArrayList<String> split(String requete) {
        ArrayList<String> split = new ArrayList<String>();
        String[] req = requete.split(" ", 0);
        for (int i = 0; i < req.length; i++) {
            split.add(req[i]);
        }
        return split;
    }

    public Table checkSelect(String requete) throws Exception {
        Table t6 = new Table();
        ArrayList<String> req = this.split(requete);
        if (req.size() == 4) {
            if (req.get(0).equalsIgnoreCase("select") && (req.get(1).equalsIgnoreCase("*"))) {
                t6 = f.Selectall(req);
            }
        } else {
            if (req.get(4).equalsIgnoreCase("where")) {
                Table t5 = f.Selectall(req);
                t6 = f.mijeryWhere(t5, req);
            }
        }
        return t6;
    }

    public Table unir(String requete) throws Exception {
        Table t3 = new Table();
        ArrayList<String> req = this.split(requete);
        if (req.get(0).equalsIgnoreCase("unir")) {
            Table t1 = c.makaTableparNom(req.get(1));
            Table t2 = c.makaTableparNom(req.get(3));
            t3 = f.union(t1, t2);
        }
        return t3;
    }

    public Table projection(String requete) throws Exception {
        ArrayList<String> req = this.split(requete);
        Table t2 = new Table();
        if (req.get(0).equalsIgnoreCase("projeter")) {
            Table t1 = c.makaTableparNom(req.get(3));
            String arechercher = req.get(1);
            t2 = f.projection(t1, arechercher);
        }
        return t2;
    }

    public Table intersection(String requete) throws Exception {
        Table t3 = new Table();
        ArrayList<String> req = this.split(requete);
        if (req.get(0).equalsIgnoreCase("intersection")) {
            Table t1 = c.makaTableparNom(req.get(2));
            Table t2 = c.makaTableparNom(req.get(4));
            t3 = f.intersection(t1, t2);
        }
        return t3;
    }

    public Table difference(String requete) throws Exception {
        Table t3 = new Table();
        ArrayList<String> req = this.split(requete);
        if (req.get(0).equalsIgnoreCase("difference")) {
            Table t1 = c.makaTableparNom(req.get(2));
            Table t2 = c.makaTableparNom(req.get(4));
            t3 = f.difference(t1, t2);
        }
        return t3;
    }

    public Table produitCartesien(String requete) throws Exception {
        Table t3 = new Table();
        ArrayList<String> req = this.split(requete);
        if (req.get(0).equalsIgnoreCase("produit") && req.get(1).equalsIgnoreCase("cartesien")) {
            Table t1 = c.makaTableparNom(req.get(3));
            Table t2 = c.makaTableparNom(req.get(5));
            t3 = f.produitCartesien(t1, t2);
        }
        return t3;
    }
}
