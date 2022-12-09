import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EcouteWindowClient implements FocusListener{
    FenetreClient fenetre;
    public FenetreClient getFenetre() {
        return fenetre;
    }
    public void setFenetre(FenetreClient fenetre) {
        this.fenetre = fenetre;
    }

    public EcouteWindowClient(FenetreClient fenetre){
        this.fenetre = fenetre;
    }
    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == fenetre.getMsgRec()) {
            if (!(fenetre.getMsgRec().getText().equals("") || fenetre.getMsgRec().getText().equals(
                    "Connected!"))) {
 
                fenetre.getWriter().println("\t ***" + fenetre.getUsername()
                        + ": The Msg is being read......***");
                fenetre.getWriter().flush();
            }
        } else if (e.getSource() == fenetre.getMsgSend()) {
            // Set Mesg sending area clear
            if (fenetre.getMsgSend().getText().equals("Write Message here")) {
                fenetre.getMsgSend().setText("");
            } else {
                fenetre.getWriter().println("\t ***" + fenetre.getUsername()
                        + ": The Msg is being typed......***");
                fenetre.getWriter().flush();
            }
 
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
       
    }
    

    

}