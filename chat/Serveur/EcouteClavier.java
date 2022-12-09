import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteClavier implements KeyListener{
    Fenetre fenetre;
    
    public Fenetre getFenetre() {
        return fenetre;
    }
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public EcouteClavier(Fenetre fenetre){
        this.fenetre = fenetre;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Fonction fonction = new Fonction(fenetre);
        // TODO Auto-generated method stub
        if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
            fenetre.getMsgSend().append("\n");
 
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            fonction.sendMessage();
        }
 
        else if ((e.getKeyCode() == KeyEvent.VK_X) ) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}