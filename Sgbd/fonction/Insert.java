package fonction;
import java.util.*;
import java.io.IOException;
import javax.swing.text.BadLocationException;

import table.*;

public class Insert{
    Create c=new Create();
    // ArrayList<String> requete="Insert into Table ";
    String requete;
    public String getRequete(){
        return this.requete;
    }
    public Insert(String requete){
        this.requete=requete;
    }


    // public void Inserer(Vector<String>donnees) throws IOException, BadLocationException{
    //     Fonction f=new Fonction();
    //     ArrayList<String>req=f.split(requete);
    //     String nom=c.getNomTable(req.get(2));
    //     Table t=new Table();
    //     t.setNom(nom);
    //     Vector<String>d=new Vector<String>();
    //     String d1="3";
    //     String d2="Aro";
    //     donnees.add(d1);
    //     donnees5.add(d2);
    //     Vector<Vector<String>> c1=new  Vector<Vector<String>>();
    //     c1.add(d);
    //     t.setDonnees(c1);         
    //     c.addField(t);
    // }

}