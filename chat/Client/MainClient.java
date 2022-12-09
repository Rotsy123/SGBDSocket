import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class MainClient{
    static ServerSocket server = null;
    static Socket socket = null;
    static String fichier;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        FenetreClient fenetre=new FenetreClient();
        fenetre.setVisible(true);
        FonctionClient fonction = new FonctionClient(fenetre);
 
        fenetre.setUsername(JOptionPane.showInputDialog("User Name (Client)"));
        fenetre.setiPAddress(JOptionPane.showInputDialog("Enter Server IpAddress"));

        // swing thread
        // (new Thread(new Runnable() {
        //     public void run() {
        //         new FenetreClient(); 
        //     }
 
        // })).start();
 
        socket = new Socket(fenetre.getiPAddress(), 60);
        fenetre.getMsgRec().setText("Connected!");
                // listening port thread
        (new Thread(new Runnable() {
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
 
                    String line = null;
                    boolean testFlag = true;
                    while ((line = reader.readLine()) != null) {
                        fenetre.getMsgRec().append("\n" + line);
                        fonction.cursorUpdate();
 
                        if (!reader.ready()) {
                            testFlag = true;
                        }
                    }
 
                } catch (IOException ee) {
                    try {
                        socket.close();
                    } catch (IOException eee) {
                        eee.printStackTrace();
                    }
                    ee.printStackTrace();
                }
            }
        })).start();
 
        try {
            fenetre.setWriter(new PrintWriter(socket.getOutputStream(), true)) ;
 
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException eee) {
            }
        }
        // if(MainServeur.fichier.equalsIgnoreCase("A:\\tt.txt")){
        //     System.out.println("ok56");
        // }

    }
}