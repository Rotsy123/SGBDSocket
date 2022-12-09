import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteClavierClient implements KeyListener{
    FenetreClient fenetre;
    
    public FenetreClient getFenetre() {
        return fenetre;
    }
    public void setFenetre(FenetreClient fenetre) {
        this.fenetre = fenetre;
    }

    public EcouteClavierClient(FenetreClient fenetre){
        this.fenetre = fenetre;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        FonctionClient fonction = new FonctionClient(fenetre);
        // TODO Auto-generated method stub
        if ((e.getKeyCode() == KeyEvent.VK_ENTER) && e.isShiftDown()) {
            fenetre.getMsgSend().append("\n");
 
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            fonction.sendMessage();
        }
 
        else if ((e.getKeyCode() == KeyEvent.VK_X) && e.isControlDown()){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}