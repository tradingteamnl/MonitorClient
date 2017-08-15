/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorclient;

import Interface.Login;
import Interface.NieuweAccount;
import global.FileSystem;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jaros
 */
public class MonitorClient extends Application {

    //variable
    private static final boolean DEV_MODUS = false;
    private static final boolean AUTO_RELOAD = false;
    private static final boolean SOCKET_SERVER_MODUS = true;
    private static final boolean CONNECT_TO_SERVER = false;

    //maak objecten aan
    FileSystem fileSystem = new FileSystem();

    @Override
    public void start(Stage primaryStage) {

        //test verbinden met de server
        if (CONNECT_TO_SERVER) {
            int port = 9099;
            String serverName = "127.0.0.1";

            try {
                System.out.println("Connecting to " + serverName + " on port " + port);
                Socket client = new Socket(serverName, port);

                System.out.println("Just connected to " + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);

                out.writeUTF("Client send " + client.getLocalSocketAddress());
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);

                System.out.println("Server says " + in.readUTF());
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //kijk het bestand bestaat
        if (fileSystem.fileExcist("wachtwoord.txt")) {

            //stuur door naar het login scherm
            Login Login = new Login();
            Login.loginScherm(primaryStage);
        } else {

            //geen wachtwoord bestand. Gebruiker door sturen naar aanmaak scherm en het opbecten maken
            System.err.println("Er is geen txt bestand gevonden met wachtwoorden.");
            NieuweAccount nieuweAccount = new NieuweAccount();
            nieuweAccount.nieuweAccount(primaryStage);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
