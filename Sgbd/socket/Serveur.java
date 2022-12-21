package socket;
import java.io.*;
import java.net.*;

import fonction.*;
import table.*;

public class Serveur {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(6666);
        try {
            Vocab v = new Vocab();
            Socket s = ss.accept();                                             // etablit la connexion
            DataInputStream dis = new DataInputStream(s.getInputStream());      //mamaky  anle message avy any @ socket
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());  //mandefa an le message

            while(true){
                String str = (String) dis.readUTF();
                Table table = v.Vocabulaire(str);
                String reponse = v.RenvoiReponse(table);
                dout.writeUTF(reponse);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}