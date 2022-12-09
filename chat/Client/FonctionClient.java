import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import java.net.*;
import java.io.*;

public class FonctionClient{
    FenetreClient fenetre;

    public FonctionClient(FenetreClient fenetre){
       this.fenetre = fenetre;
    }

    public void cursorUpdate() {
        // Update cursor position
        DefaultCaret caret = (DefaultCaret) fenetre.getMsgRec().getCaret();
        caret.setDot(fenetre.getMsgRec().getDocument().getLength());
 
        DefaultCaret caret2 = (DefaultCaret) fenetre.getMsgSend().getCaret();
        caret2.setDot(fenetre.getMsgSend().getDocument().getLength());
    }


    public void sendMessage(){
        fenetre.getWriter().println(fenetre.getUsername() + " :" + fenetre.getMsgSend().getText()); 
        fenetre.getMsgRec().append("\nMe: " + fenetre.getMsgSend().getText());
        fenetre.getWriter().flush();
        this.cursorUpdate();
 
        fenetre.getMsgSend().setText("");
        fenetre.getMsgSend().setCaretPosition(0);
    }

    

    // public void SenfFile(String path) throws IOException{
    //     // MainClient.socket = new Socket("127.0.0.1",60);
    //     FileInputStream input = new FileInputStream(new File(path));
    //     ObjectOutputStream out = new ObjectOutputStream(MainClient.socket.getOutputStream());
    //     byte buf[] =  new byte[1024];
    //     int n;
    //     while((n = input.read(buf))!=-1){
    //         out.write(buf, 0, n);
    //     } 
    //     // input.close();
    //     // out.close();
    //     // MainClient.socket.close();

    //     System.out.println("fichier envoyee");
    // }
    // public void ReceiveFile(String path)throws IOException{
    //     try{
    //         MainServeur.server = new ServerSocket(60);
    //         MainServeur.socket  = MainClient.server.accept();
    //         System.out.println("xcvfghjkiolp;['");
    //         ObjectInputStream in = new ObjectInputStream(MainServeur.socket.getInputStream());
    //         // sys
    //         System.out.println("niditrax");
    //         System.out.println("aonnaaa");
    //         FileOutputStream out = new FileOutputStream(new File(path));
    //         byte[]buf = new byte[1024];
    //         int n ;
    //         while ((n=in.read(buf))!=-1){
    //             out.write(buf,0,n);
    //         }
            
    //         out.close();
    
    //     }catch (Exception ex){

    //     }
    // }
}