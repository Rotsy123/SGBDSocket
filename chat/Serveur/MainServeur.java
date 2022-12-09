import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.*;

import javax.swing.JOptionPane;

public class MainServeur{
    static ServerSocket server = null;
    static Socket socket = null;
    static String fichier ;
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[]args) throws IOException{
            
       Fenetre fenetre=new Fenetre();
        fenetre.setVisible(true);
        Fonction fonction = new Fonction(fenetre);
        ///--------------------------------------------------

        // TODO Auto-generated method stub
        fenetre.setUsername(JOptionPane.showInputDialog("User Name (Server)")) ;
 
    
        
        server = new ServerSocket(60);
        System.out.println(server.getInetAddress().getLocalHost());
         
        socket = server.accept();
 
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
 
                        // Cursor Update
                        fonction.cursorUpdate();
                    }
 
                } catch (IOException ee) {
                    try {
                        server.close();
                        socket.close();
                    } catch (IOException eee) {
                        eee.printStackTrace();
                    }
                    ee.printStackTrace();
                }
 
            }
        })).start();
 
        try {
            fenetre.setWriter( new PrintWriter(socket.getOutputStream(), true));
 
        } catch (IOException e) {
            try {
                server.close();
                socket.close();
            } catch (IOException eee) {
            }
        }
    }
}