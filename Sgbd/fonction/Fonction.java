package fonction;

import java.util.*;
import java.io.IOException;
import javax.swing.text.BadLocationException;

import table.*;

public class Fonction{
    Create c=new Create();
    String requete;

    public ArrayList<String>split(String requete){
        ArrayList<String>split=new ArrayList<String>();
        String[]req=requete.split(" ",0);
        for(int i=0; i<req.length; i++){
            split.add(req[i]);
        }
        return split;
    }

    //Select*from tab where col==zvtr
    public Table Selectall(ArrayList<String>requete)throws IOException, BadLocationException{        
        Table table=new Table();                                   //micreer table hanasina valiny
        // int colonne;
        String nomTabl=c.getNomTable(requete.get(3));       //maka an le table anaty fichier
        String[]attributes=null;
        Vector<String>a=new Vector<String>();
        table.setNom(nomTabl);                                      
        attributes=c.getAttributes(table);                          //maka anle attributs an le table
       
        for(int i=0; i<attributes.length; i++){
            a.add(attributes[i]);
        }        
        Vector<Vector<String>>donnees=c.getField(table);           //mameno an le donnees an le table
        table.setDonnees(donnees);
        table.setAttributs(a);
        return table;
    }
    // ------------------------------------------------------
    public Table mijeryWhere(Table table,ArrayList<String>requete)throws IOException, BadLocationException{
        Vector<Vector<String>>v=new Vector<Vector<String>>();
        int i=c.makaNumattribut(requete.get(5), table);     //eto izy maka an le oe attributs fahafiry no jerena anaty condition
        v=c.makaDonnees(i, table, requete.get(7));          //maka an le donnes nifanandrify t@ conditions nangatahana
        table.setDonnees(v);    
        return table;
    } 

    //-----------------------------------------------------
            ///refa mitovy ny nombre de colonne vao afaka atambatra ny relations anaky2///
    public Table union(Table t1, Table t2)throws IOException, BadLocationException{
        Table t3=new Table();

        String[]alltab1=c.getAttributes(t1);        //maka ny attributs an le relation 1
        int nbcolonne1=alltab1.length;              

        String[]alltab2=c.getAttributes(t2);        //maka attributs an le relation2
        int nbcolonne2=alltab2.length;

        if(nbcolonne1==nbcolonne2){                 //condition ana relation
            t3.setNom(t1.getNom()+"union"+t2.getNom());
            c.creerTable(t3);
            t3.setAttributs(t2.getAttributs());
            c.addAttribut(t3);
            
            Vector<Vector<String>>allobjet=new Vector<Vector<String>>();
            allobjet=c.getFieldunion(t1, t2);               //maka ny donnees ao @ 1 sy 2 de atambatra anaty vector 2 dim 1
            t3.setDonnees(allobjet);
        }

        return t3;
    }
     
    //-------------------------------------------------------------------------------------
    //select X from Y
     
    public Table projection(Table table, String arechercher)throws IOException , BadLocationException{        
        String[]attributs=c.getAttributes(table);
        int numColonne=0;
        Vector<String>at=new Vector<String>();
        for(int i=0; i<attributs.length; i++){
             if(attributs[i].equalsIgnoreCase(arechercher)){        //mijery oe ina le colonne halaina
                at.add(attributs[i]);               
                table.setAttributs(at);
                numColonne=i+1;               
            }
        }
        Vector<Vector<String>>field=c.getField(table);
        Vector<String>fi=new Vector<String>();

        for(int i=0; i<field.size(); i++){
            for(int j=0; j<field.get(i).size(); j++){
                if(j==numColonne-1){                                //alaina izay donnees nifanandrify t@ iny colonne iny
                    String o=field.get(i).get(j);
                    fi.add(o);
                    field.get(i).setElementAt(o, j);               //soloina anle donnees mifanandrify le ao anaty table  
                }else{
                    field.get(i).removeElementAt(j);                //de supprimena le eto @ j satria refa miverina eo izy de hitany ndray de lasa miverimberina foana
                }
            }
        } 
        table.setDonnees(field);
        return table;
    }
//---------------------------------------------------------------------------------------------------
     //alaina izay ligne mitovy
    public Table intersection(Table t1, Table t2 ){
        Table t=new Table();
        t.setNom(t1.getNom()+"inter"+t2.getNom());
        Vector<Vector<String>>field1=t1.getDonnees();
        Vector<Vector<String>>field2=t2.getDonnees();
        Vector<Vector<String>>field=new Vector<Vector<String>>();

        Vector<String> nomAttribut=new Vector<String>();
        Vector<String> at1=t1.getAttributs();
        Vector<String> at2=t2.getAttributs();

        for(int i=0; i<at1.size(); i++){
            nomAttribut.add(at1.get(i)+"_inter_"+at2.get(i));
        }
        t.setAttributs(nomAttribut);       
        for(int i=0; i<field1.size();i++){
            for(int j=0; j<field2.size(); j++){
                if(field1.get(i).equals(field2.get(j))){        //alaina izay mitovy @ ligne-na donnees 
                    field.add(field1.get(i));
                }
            }
        }
        t.setDonnees(field);
        return t;
    }

//-------------------------------------------------------------------------------------------------
/*esorina izay ligne mitovy */
    public Table difference(Table t1, Table t2){
        Table t=new Table();
        t.setNom(t1.getNom()+"differ"+t2.getNom());
        Vector<Vector<String>>field1=t1.getDonnees();
        Vector<Vector<String>>field2=t2.getDonnees();
        Vector<Vector<String>>field=new Vector<Vector<String>>();
       
        Vector<String> nomAttribut=new Vector<String>();
        Vector<String> at1=t1.getAttributs();
        Vector<String> at2=t2.getAttributs();

        for(int i=0; i<at1.size(); i++){
            nomAttribut.add(at1.get(i)+"_difference_"+at2.get(i));
        }
        t.setAttributs(nomAttribut);

        Table intersection=intersection(t1, t2);
        for(int i=0; i<field1.size(); i++){
            for(int j=0; j<intersection.getDonnees().size(); j++){
                if(field1.get(i).equals(intersection.getDonnees().get(j))){
                }else{
                    field.add(field1.get(i));
                }
            }
        }
        for(int i=0; i<field2.size(); i++){
            for(int j=0; j<intersection.getDonnees().size(); j++){
                if(field2.get(i).equals(intersection.getDonnees().get(j))){
                }else{
                    field.add(field2.get(i));
                }
            }
        }
        t.setDonnees(field);
        return t;
     }

    public Table produitCartesien(Table t1, Table t2){
        Table t=new Table();
        t.setNom(t1.getNom()+"x"+t2.getNom());
        Vector<Vector<String>>field1=t1.getDonnees();
        Vector<Vector<String>>field2=t2.getDonnees();
        Vector<Vector<String>>field=new Vector<Vector<String>>();
       
        Vector<String> at1=t1.getAttributs();
        Vector<String> at2=t2.getAttributs();
        Vector<String> nomAttr=new Vector<String>();

        for(int i=0; i<at1.size(); i++){
            nomAttr.add(at1.get(i));
        }
      
        for(int j=0; j<at2.size(); j++){
            nomAttr.add(at2.get(j));
        }
        t.setAttributs(nomAttr);

        int k=field2.get(0).size();
        System.out.println(field2.size());
        System.out.println(field1.size());

        if(field1.size()>field2.get(0).size()){
            for(int i=field2.size(); i<field1.size(); i++){         //raha le   relaton1 lehibe noho ny relation2 de ataony null ny famenon'ny relation2
                String tt = "null";
                Vector<String>nulll = new Vector<String>(); 
                nulll.add(tt);
                nulll.add(tt);
                field2.add(nulll);
            }
        }else if(field2.size()>field1.get(0).size()){             //raha le   relaton2 lehibe noho ny relation1 de ataony null ny famenon'ny relation2
            for(int i=field1.size(); i<field2.size(); i++){
                String tt = "null";
                Vector<String>nulll = new Vector<String>(); 
                nulll.add(tt);
                nulll.add(tt);
                field1.add(nulll);
            }
        }
        for(int i=0; i<field1.size(); i++){
            for(int j=0; j<k; j++){
                System.out.println(field2.get(i));
                    field1.get(i).add(field2.get(i).get(j));            //atao meme ligne izy refa mitovy indice
            }
        }
        t.setDonnees(field1);
        return t;
    }

//-----------------------------------------------------------------------------//

// public Table Division(Table t1, Table t2){
//     Table t=new Table();
//     Vector<Integer>hapotramitovy=new Vector<Integer>();

//     t.setNom(t1.getNom()+"divider_par"+t2.getNom());

//     Vector<Vector<String>>dt1=t1.getDonnees();
//     Vector<Vector<String>>dt2=t2.getDonnees();

//     Vector<String>at1=t1.getAttributs();
//     Vector<String>at2=t2.getAttributs();
//     Vector<String>nomAttributTable=new Vector<String>();
    
//     for(int i=0; i<at1.size(); i++){
//         for(int j=0; j<at2.size(); j++){
//             if(at1.get(i).equals(at2.get(j))){               
//                 hapotramitovy.add(j);
//                 at1.removeElementAt(i);              
//             }else{
//                 nomAttributTable.add(at1.get(i)); 
//             }
//         }
//    }
//    Vector<String>mitovy=new Vector<String>();

//    for(int k=0; k<hapotramitovy.size(); k++){
//         for(int i=0; i<dt1.size(); i++){
//             for(int j=0; j<dt2.size(); j++){
//                 if(dt1.get(i).get(hapotramitovy.get(k)).equalsIgnoreCase(dt2.get(j).get(hapotramitovy.get(k)))){
//                     mitovy.add(dt1.get(i).get(hapotramitovy.get(k)));
//                 }
//             }
//         }

//     }
//     for(int i=0; i<dt1.size(); i++){
//         for(int j=0; j<dt1.get(i).size(); j++){
//             for(int k=0; k<mitovy.size(); k++){
//                 if(dt1.get(i).get(j).equalsIgnoreCase(mitovy.get(k))){
//                     dt1.get(i).removeElementAt(j);
//                 }
//             }
//         }
//     }
//     t.setAttributs(nomAttributTable);
    

//     t.setDonnees(dt1);
//     return t;
// }


}