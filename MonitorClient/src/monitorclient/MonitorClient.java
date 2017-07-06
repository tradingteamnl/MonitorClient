/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorclient;

import Interface.Login;
import Interface.NieuweAccount;
import global.FileSystem;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jaros
 */
public class MonitorClient extends Application {

    //maak objecten aan
    FileSystem fileSystem = new FileSystem();

    @Override
    public void start(Stage primaryStage) {

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
    public void opstrarten(String[] args) {
        launch(args);
    }

}
