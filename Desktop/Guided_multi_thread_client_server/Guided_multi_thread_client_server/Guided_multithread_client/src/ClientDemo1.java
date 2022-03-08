/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author wafa
 */
public class ClientDemo1 {
    public static void main(String[] args) {
 
  
       final String serverHost = "localhost";
       int serverPort = 7771;
       Socket socketOfClient = null;
       DataOutputStream dos = null;
       DataInputStream dis = null;
 
       try {
      
            
           // Send a request to connect to the server is listening
           // on machine 'localhost' port 7777. 
    	   //TODO Cr�er la socket sur le serverHost et le port7771
    	   socketOfClient = new Socket(serverHost, serverPort);
      
           // TODO Create output stream at the client (to send data to the server)
           dos = new DataOutputStream(new BufferedOutputStream(socketOfClient.getOutputStream()));
 
      
           // TODO Input stream at Client (Receive data from the server).
           dis = new DataInputStream(new BufferedInputStream(socketOfClient.getInputStream()));
 
       }

        catch (UnknownHostException e) {
           System.err.println("Don't know about host " + serverHost);
           return;
       } 
       catch (IOException e) {
           System.err.println("Couldn't get I/O for the connection to " + serverHost);
           return;
       }
 Scanner scan=new Scanner(System.in);
       try {
            String firstmessageToServer = scan.nextLine();
           // Write data to the output stream of the Client Socket.
           dos.writeUTF(firstmessageToServer);
           // Flush data
           dos.flush();  
           
         String secondMessageToServer = scan.nextLine();
           dos.writeUTF(secondMessageToServer);
           dos.flush();
        String thirdMessageToServer = scan.nextLine();
           dos.writeUTF(thirdMessageToServer);  
           dos.flush();
 
      
            
           // Read data sent from the server.
           // By reading the input stream of the Client Socket.
           String responseLine;
           while ((responseLine = dis.readUTF()) != null) {
               System.out.println("Server: " + responseLine);
               if (responseLine.indexOf("OK") != -1) {
                   break;
               }
           }
 
           dos.close();
           dis.close();
           socketOfClient.close();
       } catch (UnknownHostException e) {
           System.err.println("Trying to connect to unknown host: " + e);
       } catch (IOException e) {
           System.err.println("IOException:  " + e);
       }
   }
}
