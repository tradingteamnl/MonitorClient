/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorclient;

import Interface.Login;
import Interface.NieuweAccount;
import InterfaceMethoden.InlogControle;
import global.FileSystem;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jaros
 */
public class MonitorClient extends Application {
    
    //maak objecten aan
    Login Login = new Login();
    InlogControle InlogControle = new InlogControle();
    FileSystem fileSystem = new FileSystem();
    NieuweAccount nieuweAccount = new NieuweAccount();
    
    @Override
    public void start(Stage primaryStage) {
        
        //kijk het bestand bestaat
        if(fileSystem.fileExcist("wachtwoord.txt")){
           //stuur door naar het login scherm
           Login.loginScherm(primaryStage);
        } else {
            //geen wachtwoord bestand. Gebruiker door sturun naar aanmaak scherm
            System.err.println("Er is geen txt bestand gevonden met wachtwoorden.");
            nieuweAccount.nieuweAccount(primaryStage);
            
        }
        //Login.loginScherm(primaryStage);
    
    
    }

    /**
     * @param args the command line arguments
     */
    public void opstrarten(String[] args) {
        //boolean firstLogin = InlogControle.firstLogin();
        launch(args);

    }

}
