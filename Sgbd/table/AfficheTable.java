package table;

public class AfficheTable{
    Table table;
    public Table getTable(){
        return this.table;
    }
    public AfficheTable(Table table){
        for(int i=0; i<table.getAttributs().size(); i++){
            System.out.print("--------------"+table.getAttributs().get(i)+"--------------");
            
        }
        System.out.println(" ");
        for(int i=0; i<table.getDonnees().size(); i++){
            for(int j=0; j<table.getDonnees().get(0).size(); j++){
                System.out.print("--------------"+table.getDonnees().get(i).get(j)+"--------------");
            }
            System.out.println("    ");
        }
        
    }
}