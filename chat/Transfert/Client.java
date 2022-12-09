import java.io.*;
import java.net.*;

public class Client{
    static Socket s ;
    public static void main (String[]args) throws IOException{
        s = new Socket("127.0.0.1",60);
        FileInputStream input = new FileInputStream(new File("A:\\jar_files.zip"));
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        byte buf[] =  new byte[1024];
        int n;
        while((n = input.read(buf))!=-1){
            out.write(buf, 0, n);
        } 
        input.close();
        out.close();
        s.close();
    }  
}