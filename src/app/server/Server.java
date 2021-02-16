package app.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;

public class Server {

    //On initialise des valeurs par défaut
    private int port = 2345;
    private String host = "127.0.0.1";
    private ServerSocket server = null;
    private boolean isRunning = true;

    public Server(){
        try {
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server(String pHost, int pPort){
        host = pHost;
        port = pPort;
        try {
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     //On lance notreserveur
    public void open(){


        //Toujours dans un thread à part vu qu'il est dans une boucle infinie
        Thread t = new Thread(new Runnable(){
            public void run(){

                //Connexion SQL
                try {
                    //Chargement des JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
                    //Connexion à la BDD
                    Connection con = DriverManager.getConnection("jdbc:mysql://barn-e-01:3306/1920_INFO2_Atla?useSSL=false",
                            "1920_INFO2_Atla","ARUfBWZ2PKXNKZwGGCc79U6a4mHs9n3G");
                    System.out.println("Serveur connecté à la base SQL");


                while(isRunning == true){

                    try {
                        //On attend une connexion d'un client
                        Socket client = server.accept();

                        //Une fois reçue, on la traite dans un thread séparé
                        System.out.println("Connexion cliente reçue.");
                        Statement sqlStatement = con.createStatement();
                        Thread t = new Thread(new ClientProcessor(client, sqlStatement));
                        t.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    server = null;
                }
            }
        });

        t.start();
    }

    public void close(){
        isRunning = false;
    }
}