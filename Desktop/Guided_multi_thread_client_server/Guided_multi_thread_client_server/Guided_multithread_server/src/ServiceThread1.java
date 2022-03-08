
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
import java.util.Scanner;

import static java.rmi.server.LogStream.log;

/**
 *
 * @author wafa
 */
//Done Add extends Thread
public class ServiceThread1 extends Thread {
 
       private int clientNumber;
       private Socket socketOfServer;
  

        
       public ServiceThread1(Socket socketOfServer, int clientNumber) {
           this.clientNumber = clientNumber;
           this.socketOfServer = socketOfServer;
 
           // Log
           ServerProgram1.log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
       }
 
      //TODO add notation override
       @Override
       public void run() {
 
           try {
 
               // Open input and output streams
               DataInputStream dis = new DataInputStream(new BufferedInputStream(socketOfServer.getInputStream()));
               DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketOfServer.getOutputStream()));
               Scanner scan=new Scanner(System.in);
               while (true) {
                ServerProgram1.log("Hello Client Number "+clientNumber+"! Welocme to Cinema Booking");
                  String firstmessageFromClient = dis.readUTF();
               
                
                ServerProgram1.log("choose movie");
                String Name = dis.readUTF();
                  
                  
                  ServerProgram1.log("how many seats you want to book");
                   String Nb = dis.readUTF();
                   ServerProgram1.run(Name,Nb);
                   dos.writeUTF("data:"+Name+Nb);
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
