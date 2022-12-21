package table;
import java.util.*;

public class Table{
    String nom;
    Vector<String>attributs;
    Vector<Vector<String>>donnees;

    public String getNom(){
        return this.nom;
    }
    public void setNom(String Nom){
        this.nom=Nom;
    }


    public Vector<String>getAttributs(){
        return this.attributs;
    }
    public void setAttributs(Vector<String>attributs){
        this.attributs=attributs;
    }

    
    public Vector<Vector<String>> getDonnees(){
        return this.donnees;
    }
    public void setDonnees(Vector<Vector<String>>donnees){
        this.donnees=donnees;
    }

    public Table(){

    } 
}