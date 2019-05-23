package netTest;
import java.io.*;
import java.net.*;

public class Client{
    
    public void go(){   
         
        try{
            //make a socket connection
            Socket s = new Socket("127.0.0.1", 4242);
            //make a stream reader with the socket
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            //make a buffered reader with the stream reader
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println(advice);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: handle exception
            }
        }
    
        public static void main(String[] args) throws IOException{
            Client c = new Client();
            c.go();
        }
}