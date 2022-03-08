
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author wafa
 */
public class ServerProgram1 {
    private static String [] cinema = {"Luther","Salt","Next"};
    private static int [] spec = {100,300,80};
    private static int [] res = {90,298,77};
   public static void main(String args[]) throws IOException {

 
       ServerSocket serverSocket = null;
       int port =7771;
       System.out.println("Server is waiting to accept user...");
       int clientNumber = 1;
 
       // Try to open a server socket on port 7777
       // Note that we can't choose a port less than 1023 if we are not
       // privileged users (root)
 
       try {
    	   //TODO Crï¿½er une serverSocket sur le port 7771
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
               //TODO Crï¿½er le thread responsable de gestion du client
               new ServiceThread1(socket, clientNumber++).start();
           }
       } finally {
           serverSocket.close();
       }
 
   }
 
   public static void log(String message) {
       System.out.println(message);
   }            

public static void run(String Name,String Nb){

            if (Name.equals("Luther")) {
             	System.out.println(spec[0]);
             	if (Integer.parseInt(Nb) + res[0] <spec[0]) {
             		System.out.println("resrvéé");
             	}
             	else {System.out.println("pas de place");}
             }
             if (Name.equals("Salt")) {
             	System.out.println(spec[1]);
             	if (Integer.parseInt(Nb) +res[1] > spec[1]) {
             		System.out.println("resrvéé");
             	}
             	else {System.out.println("pas de place");}
             }
             if (Name.equals("Next")) {
            	 System.out.println(spec[2]);
            	if (Integer.parseInt(Nb) + res[2] > spec[2]) {
            		System.out.println("resrvéé");
         	}
         	else {System.out.println("pas de place");}
             }
             }
}

