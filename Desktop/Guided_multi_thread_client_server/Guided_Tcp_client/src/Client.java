
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.BufferedInputStream;


// Client for Server1, Server2, Server3
public class Client {
	//TODO Ajouter le nom du serveur
    private String serverName="localhost";	
    private int serverPort = 8081;
    private Socket socket = null;
    private DataOutputStream dos = null;
    private DataInputStream dis = null;
    private BufferedInputStream bis = null;

    public Client() {
        try {
        	//TODO cr�er une nouvelle socket
        	socket = new Socket(serverName,serverPort);
            //TODO récupérer le num�ro de port du socket c�t� client
        	System.out.println("Client started on port"+ socket.getLocalPort()+"...");
            //TODO r�cup�rer le num�ro de port du socket c�t� serveur
        	System.out.println("Connected to "+socket.getRemoteSocketAddress());
                
            //TODO obtenir le flux d'�criture pour envoyer le message
        	dos = new DataOutputStream(socket.getOutputStream());
            bis = new BufferedInputStream(socket.getInputStream());
            dis = new DataInputStream(bis);
        	
            Scanner scan=new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Message to server : ");
                    String messageToServer = scan.nextLine();
                    if(messageToServer.equals("exit")){
                        break;
                    }
                  dos.writeUTF(messageToServer); 
                  dos.flush();
                  String messageFromServer = dis.readUTF();
                  System.out.println("Client["+ socket.getRemoteSocketAddress()+"] :"+ messageFromServer);
                }
                 catch (IOException e) {
                    break;
                }
            }
          //TODO fermer le flux d'�criture et le socket
           dos.close();
            
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        Client client = new Client();
    }
}