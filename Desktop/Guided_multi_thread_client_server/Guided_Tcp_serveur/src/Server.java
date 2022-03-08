import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataOutputStream;
// SERVER : Single Server                       
// TIPE : One-Way Communication (Client to Server)
// DESCRIPTION : 
// A simple server that will accept a single client connection and display everything the client says on the screen. 
// If the client user types "exit", the client and the server will both quit.
public class Server {

    private int port = 8081;
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private BufferedInputStream bis = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;

    public Server() {
        try {
        	//TODO Cr�er une socket pour �couter les clients
        	serverSocket = new ServerSocket(port);
          //TODO Afficher le port local du serveur
        	System.out.println("Server started on" + serverSocket.getLocalPort() +" connected to server");
            System.out.println("Waiting for client...");

          //TODO Le serveur accepte une demande de connexion
            socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected to server...");

            //TODO Obtenir le flux d'entr�e pour obtenir les informations parvenues de la socket
            bis = new BufferedInputStream(socket.getInputStream());

            //TODO Lire le data input stream
            dis = new DataInputStream(bis);
            dos = new DataOutputStream(socket.getOutputStream());
            Scanner scan=new Scanner(System.in);

            while (true) {
                try {
                    String messageFromClient = dis.readUTF();
                    if (messageFromClient.equals("exit")) {
                        break;
                    }
                    //TODO afficher l'adresse du client et le message envoyer par le client
                    System.out.println("Client["+ socket.getRemoteSocketAddress()+"] :"+ messageFromClient);  
                    System.out.print("Message to CLIENT : ");
                    String messageToClient = scan.nextLine();
                    dos.writeUTF(messageToClient); 
                    dos.flush();                  
                }
                
                
                catch (IOException e) {
                    break;
                }
            }
            dos.close();
            dis.close();
            socket.close();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnect from server...");
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}