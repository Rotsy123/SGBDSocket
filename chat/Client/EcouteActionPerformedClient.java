import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.io.*;

public class EcouteActionPerformedClient implements ActionListener{
    FenetreClient fenetre;
    String path;
    public FenetreClient getFenetre() {
        return fenetre;
    }
    public void setFenetre(FenetreClient fenetre) {
        this.fenetre = fenetre;
    }
    
    public EcouteActionPerformedClient(FenetreClient fenetre){
        this.fenetre = fenetre; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object scr = e.getSource();
        FonctionClient fonction = new FonctionClient(fenetre);
        if (scr == fenetre.getSend()) {
            fonction.sendMessage();
            System.out.println("lasaaaa");
        } else if (scr == fenetre.getLogOut()) {
 
            System.exit(0);
 
        } else if (scr == fenetre.getS_keys()) {
 
            JOptionPane.showMessageDialog(fenetre,"(shift+Enter) raha te hidina an-dalana"+ "\n(ctrl+x) raha hiala");
 
        } else if (scr == fenetre.getAbout()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Chat application");
        } 
        // else if (scr == fenetre.getEnvoyerfichier()){
        //     path= JOptionPane.showInputDialog("Path of files");
        //     try {
        //         fonction.SenfFile(path);
        //         String patth21 = JOptionPane.showInputDialog("Telecharger le fichier");
        //         MainServeur.fichier = patth21;            
        //         System.out.println(MainServeur.fichier);              
        //     } catch (IOException e1) {
        //         // TODO Auto-generated catch block
        //         e1.printStackTrace();
        //     }             
        // }
           
    }
}
