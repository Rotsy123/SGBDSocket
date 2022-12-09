import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;


public class EcouteActionPerformed implements ActionListener{
    Fenetre fenetre;
    static int huhu=0;
    public Fenetre getFenetre() {
        return fenetre;
    }
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }
    
    public EcouteActionPerformed(Fenetre fenetre){
        this.fenetre = fenetre; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object scr = e.getSource();
        String path=null;
        Fonction fonction = new Fonction(fenetre);
        if (scr == fenetre.getSend()) {
            fonction.sendMessage();

        } else if (scr == fenetre.getLogOut()) {
 
            System.exit(0);
 
        } else if (scr == fenetre.getS_keys()) {
            JOptionPane.showMessageDialog(fenetre,"(shift+Enter) raha te hidina an-dalana"+ "\n(ctrl+x) raha hiala");
 
        } else if (scr == fenetre.getAbout()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Chat application");
        }else if(scr == fenetre.getBleu()){
            fenetre.getMsgRec().setBackground(Color.BLUE);
        }else if(scr == fenetre.getRouge()){
            fenetre.getMsgRec().setBackground(Color.RED);
        }
        }
    }
