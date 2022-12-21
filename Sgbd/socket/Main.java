package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import fonction.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Boolean huhu = true;
        Vocabulaire vocabulaire = new Vocabulaire();
        Vocab v = new Vocab();
        
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 6666);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            while (huhu == true) {
                System.out.println("");
                String message = sc.nextLine();
                dout.writeUTF(message);
                dout.flush();          
                System.out.println("message=" );            
                System.out.println(in.readUTF());
    
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}