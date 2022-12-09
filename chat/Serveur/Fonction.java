import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class Fonction{
    Fenetre fenetre;

    public Fonction(Fenetre fenetre){
       this.fenetre = fenetre;
    }

    public void cursorUpdate() {
        // Update cursor position
        DefaultCaret caret = (DefaultCaret) fenetre.getMsgRec().getCaret();
        caret.setDot(fenetre.getMsgRec().getDocument().getLength());
 
        DefaultCaret caret2 = (DefaultCaret) fenetre.getMsgSend().getCaret();
        caret2.setDot(fenetre.getMsgSend().getDocument().getLength());
    }

    public void sendMessage() {
        fenetre.getWriter().println(fenetre.getUsername() + " :" + fenetre.getMsgSend().getText());
        fenetre.getWriter().flush();
 
        fenetre.getMsgRec().append("\nMe: " + fenetre.getMsgSend().getText());
 
        cursorUpdate();
 
        fenetre.getMsgSend().setText("");
        fenetre.getMsgSend().setCaretPosition(0);
    }

    // public void ReceiveFile(String path){
    //     try{
    //         // MainClient.server = new ServerSocket(60);
    //         Socket s = MainClient.server.accept();
    //         ObjectInputStream in = new ObjectInputStream(s.getInputStream());
    //         FileOutputStream out = new FileOutputStream(new File(path));
    //         System.out.println("AOOOOOOOOOOOOOOOOOOOOOOOOOO");
    //         byte[]buf = new byte[1024];
    //         int n ;
    //         while ((n=in.read(buf))!=-1){
    //             out.write(buf,0,n);
    //         }
    //         // out.close();
    
    //     }catch (Exception ex){

    //     }
    // }
    
}