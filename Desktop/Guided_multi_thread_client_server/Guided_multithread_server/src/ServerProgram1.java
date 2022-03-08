
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerProgram1 {
     
   public static void main(String args[]) throws IOException {
 
       ServerSocket serverSocket = null;
       int port =7771;
       System.out.println("Server is waiting to accept user...");
       try {
    	   //TODO Créer une serverSocket sur le port 7771
           serverSocket = new ServerSocket(port);
       } catch (IOException e) {
           System.out.println(e);
           System.exit(1);
       }
 
       try {
           while (true) {
               // Accept client connection request
               // Get new Socket at Server.
 
               Socket socket = serverSocket.accept();
              
           }
       } finally {
           serverSocket.close();
       }
 
   }
 
   public static void log(String message) {
       System.out.println(message);
   }
}
