
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import static java.rmi.server.LogStream.log;


//Done Add extends Thread
public class ServiceThread1 extends Thread {
 
       private int clientNumber;
       private Socket socketOfServer;
       private String [] cinema = {"Luther","Salt","Next"};
       private int [] spec = {100,300,80};
       private int [] resrv = {90,299,77};
       public ServiceThread1(Socket socketOfServer, int clientNumber) {
           this.clientNumber = clientNumber;
           this.socketOfServer = socketOfServer;
 
           // Log
           ServerProgram1.log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
       }
 
       @Override
       public void run() {
 
           try {
 
               // Open input and output streams
               DataInputStream dis = new DataInputStream(new BufferedInputStream(socketOfServer.getInputStream()));
               DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketOfServer.getOutputStream()));
 
               while (true) {
                           
            	   String messageFromClient = dis.readUTF();
                   if (messageFromClient.equals("Luther")) {
                    	System.out.println(spec[0]);
                    	String messageFromClient_1 = dis.readUTF();
                    	if (Integer.parseInt(messageFromClient_1) - spec[0] > 0) {
                    		System.out.println("resrvéé");
                    	}
                    	else {System.out.println("pas de place");}
                    	break;
                    }
                    if (messageFromClient.equals("Salt")) {
                    	System.out.println(spec[1]);
                    	String messageFromClient_1 = dis.readUTF();
                    	if (Integer.parseInt(messageFromClient_1) - spec[1] > 0) {
                    		System.out.println("resrvéé");
                    	}
                    	else {System.out.println("pas de place");}
                    	break;
                    }
                    if (messageFromClient.equals("Next")) {
                   	 System.out.println(spec[2]);
                   	String messageFromClient_1 = dis.readUTF(); 
                   	if (Integer.parseInt(messageFromClient_1) - spec[2] > 0) {
                		System.out.println("resrvéé");
                	}
                	else {System.out.println("pas de place");}
                    	break;
                    }
                   // Flush data.
                   dos.flush();
                   break;
            
                  
               }
 
           } catch (IOException e) {
               System.out.println(e);
               e.printStackTrace();
           }
       }
   }
