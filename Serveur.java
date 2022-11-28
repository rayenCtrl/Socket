import java.io.*;
import java.net.*;

public class Serveur {
  static final int PORT = 1200;
  public static void main(String[] args) throws Exception {
      // Création d'un objet S à l'écoute du port spécifié
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("En attente de connexion");
    Socket socClient = s.accept(); // L'acceptation d'une connexion d'un client
    System.out.println("Connexion etablie");
    
    BufferedReader entreeServeur=new BufferedReader(new InputStreamReader(socClient.getInputStream()));
    PrintWriter sortieServeur=new PrintWriter(new BufferedWriter
                                        (new OutputStreamWriter(socClient.getOutputStream())),
                                        true);
    String str = entreeServeur.readLine(); // lecture du message envoyé par le client
    String strMajscule = str.toUpperCase();

    s.close();
    System.out.println("le message en maj est "+ strMajscule);
    entreeServeur.close();
    sortieServeur.close();
    socClient.close();
  }
}