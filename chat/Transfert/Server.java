import java.io.*;
import java.net.*;

public class Server{
    static Socket sock;
    static ServerSocket sv;
    public static void main(String[]args) throws IOException{
        try{
            sv = new ServerSocket(60);
            Socket s = sv.accept();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            FileOutputStream out = new FileOutputStream(new File("A:\\jar.zip"));
            byte[]buf = new byte[1024];
            int n ;
            while ((n=in.read(buf))!=-1){
                out.write(buf,0,n);
            }
            out.close();
            sock.close();
        }catch (Exception ex){

        }
    }
}