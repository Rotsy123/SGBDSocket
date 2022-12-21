package table;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.text.BadLocationException;

public class Create{
    public void creerTable(Table table)throws IOException, BadLocationException{
        File fichier=new File("donnees\\Table.txt");
        FileOutputStream file=new FileOutputStream(fichier,true);
        file.write(table.getNom().getBytes());
        String separateur="//";
        file.write(separateur.getBytes());
        file.close();
    }
    public String[] getNomTables()throws IOException{
        File file = new File("donnees\\Table.txt");
        BufferedReader isp=new BufferedReader(new FileReader(file));
        String d;
        String[] vobject=null;
        while((d=isp.readLine())!=null){
            vobject=d.split("//",0);   
        }
        isp.close();
        return vobject;
    }
    public boolean checktable(String nomTable)throws IOException{
        String[]alltab=this.getNomTables();
        boolean vrai=true;
        for(int i=0; i<alltab.length; i++){
            if(alltab[i].equalsIgnoreCase(nomTable)){
                vrai=true;
                
            }else{
                vrai=false;
            }
        }
        return vrai;
    }
    public String getNomTable(String nomTable)throws IOException{
        String[]alltab=this.getNomTables();
        String nom="nom";
        for(int i=0; i<alltab.length; i++){
            if(alltab[i].equalsIgnoreCase(nomTable)){
                nom=alltab[i];
            }
        }
        return nom;
    }
    
    //-------------------------------------------------------------------------
    public void addAttribut(Table table)throws IOException{
        File e = new File("donnees\\"+table.getNom()+"attribut.txt");
        FileOutputStream file=new FileOutputStream(e,true);
        boolean tableExiste=this.checktable(table.getNom());
        if(tableExiste==true){
            for(int i=0;i<table.getAttributs().size();i++){        
                file.write(table.getAttributs().get(i).getBytes());
                String sep=";;";
                file.write(sep.getBytes());
            }
        }else{
            System.out.println("Table inexistante");
        }
        file.close();
    }
    public String[] getAttributes(Table table)throws IOException{
        File file = new File("donnees\\"+table.getNom()+".txt");
        BufferedReader isp=new BufferedReader(new FileReader(file));
        String d;
        String[] vobject=null;
        while((d=isp.readLine())!=null){
            vobject=d.split(";;",0);   
        }
        isp.close();
        return vobject;
    }
    public int checkAttribut(Table table)throws IOException{
        String[]alltab=getAttributes(table);
        int allchecked=alltab.length;
        for(int i=0; i<alltab.length; i++){
            
            if(alltab[i].equalsIgnoreCase(table.getAttributs().get(i))){
                allchecked=allchecked-1;    
            }else{
                
            }
        }
        return allchecked;
    }
//---------------------------------------------------------------------------------
    public void addField(Table table) throws IOException, BadLocationException{
        File e = new File("donnees\\"+table.getNom()+"donnees.txt");
        FileOutputStream file=new FileOutputStream(e,true);
        int allchecked=checkAttribut(table);
        if(allchecked==0){
            for(int i=0;i<table.getDonnees().size();i++){
                for(int j=0;j<table.getDonnees().get(i).size();j++){
                    file.write(table.getDonnees().get(i).get(j).getBytes());
                    String sep=";;";
                    file.write(sep.getBytes());
                }
                String separateur="//";
                file.write(separateur.getBytes());
            }
            System.out.println("Insertion reussie");

        }else{
            System.out.println("il manque d'autres attributs");
        }
        file.close();
    }

//---------------------------------------------------------------------------------------
    public Vector<Vector<String>> getField(Table table)  throws IOException, BadLocationException{
        File file = new File("donnees\\"+table.getNom()+"donnees.txt");
        BufferedReader isp=new BufferedReader(new FileReader(file));
        String d;
        Vector<String>objet=new Vector<String>();
        Vector<Vector<String>>allobjet=new Vector<Vector<String>>();
        String[]dd;  
        String[] vobject=null;
        while((d=isp.readLine())!=null){
            vobject=(d.split("//",0));   
        }              
        for(int i=0; i<vobject.length; i++){
            dd=vobject[i].split(";;",0);
            Vector<String>a=new Vector<String>();
            for(int j=0; j<dd.length; j++ ){
                a.add(dd[j]);
            }
            objet=a;
            allobjet.add(objet);
        }
        isp.close();
        return allobjet;
    }

    //----------------------------------------------------------------------------------------------------
        /*maka an le donnees an le t1 sy t2 de atambatra anaty vector a 2 dim 1 */
    public Vector<Vector<String>> getFieldunion(Table t1, Table t2)  throws IOException, BadLocationException{
        File file = new File("donnees\\"+t1.getNom()+"donnees.txt");
        BufferedReader isp=new BufferedReader(new FileReader(file));
        String d;
        Vector<String>objet=new Vector<String>();
        Vector<Vector<String>>allobjet=new Vector<Vector<String>>();
        String[]dd;  
        String[] vobject=null;
        while((d=isp.readLine())!=null){
            vobject=(d.split("//",0));   
        }              
        for(int i=0; i<vobject.length; i++){
            dd=vobject[i].split(";;",0);
            Vector<String>a=new Vector<String>();
            for(int j=0; j<dd.length; j++ ){
                a.add(dd[j]);
            }
            objet=a;
            allobjet.add(objet);
        }
        isp.close();

        File file2 = new File("donnees\\"+t2.getNom()+"donnees.txt");
        BufferedReader isp2=new BufferedReader(new FileReader(file2));
        String d2;
        Vector<String>objet2=new Vector<String>();
       
        String[]dd2;  
        String[] vobject2=null;
        while((d2=isp2.readLine())!=null){
            vobject2=(d2.split("//",0));   
        }              
        for(int i=0; i<vobject2.length; i++){
            dd2=vobject2[i].split(";;",0);
            Vector<String>a2=new Vector<String>();
            for(int j=0; j<dd2.length; j++ ){
                a2.add(dd2[j]);
            }
            objet2=a2;
            allobjet.add(objet2);
        }
        isp2.close();

        return allobjet;
    }
    //--------------------------------------------------------------------------------------------
    //maka numero an le colonne hijerevana azy any anaty base
    public int makaNumattribut(String attribut,Table table)throws IOException, BadLocationException{
        String[]allattributs=getAttributes(table);
        int indice=1000;
        for(int i=0; i<allattributs.length; i++){
            if(allattributs[i].equalsIgnoreCase(attribut)){
                indice=i;
            }
        }
        return indice;
    }
    //maka donnees % attribut 
    public Vector<Vector<String>>makaDonnees(int num, Table table,String value)throws IOException, BadLocationException{  
        Vector<Vector<String>>donnees=getField(table);
        Vector<Vector<String>>d=new Vector<Vector<String>>();
        for(int i=0; i<donnees.size(); i++){
            for(int j=0; j<donnees.get(0).size(); j++){
                //le j iny no indice an le attribut de par rapport @ iny no ijerevana anle valeur
                if(j==num && value.equalsIgnoreCase(donnees.get(i).get(j))){                    
                    Vector<String>v=donnees.get(i);
                    d.add(v);
                }
            }
        }
        return d;
    }
public Table makaTableparNom(String nom)throws IOException, BadLocationException{
    Table table=new Table();
    String nomTabl=this.getNomTable(nom);
    table.setNom(nomTabl);
    String[]at=getAttributes(table);
    Vector<String>atr=new Vector<String>();
    for(int i=0; i<at.length; i++){
        atr.add(at[i]);
    }
    table.setAttributs(atr);
    table.setDonnees(getField(table));
    return table;
    }
}