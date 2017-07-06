/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorclient;

import Interface.Login;
import InterfaceMethoden.InlogControle;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jaros
 */
public class MonitorClient extends Application {

    Login Login = new Login();
    InlogControle InlogControle = new InlogControle();

    @Override
    public void start(Stage primaryStage) {
        Login.loginScherm(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public void opstarten(String[] args) {
        //boolean firstLogin = InlogControle.firstLogin();
        launch(args);

    }

}
