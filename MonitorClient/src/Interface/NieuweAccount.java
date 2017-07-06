package Interface;

import InterfaceMethoden.InlogControle;
import InterfaceMethoden.InterfaceGlobal;
import Security.Encrypt;
import global.FileSystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author michel
 */
public class NieuweAccount {

    //maak objecten aan
    InlogControle InlogControle = new InlogControle();
    InterfaceGlobal GlobalI = new InterfaceGlobal();
    Encrypt encrypt = new Encrypt();
    FileSystem fileSystem = new FileSystem();

    /**
     *
     * @param primaryStage Interface
     */
    public void nieuweAccount(Stage primaryStage) {

        System.out.println("nieuweAccount");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Welkom + Letter type
        Text scenetitle = new Text("No account detect. Please make a account.");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Username text
        Label userNameLabel = new Label("Username:");
        grid.add(userNameLabel, 0, 1);

        //Text veld na Username
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Password text
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        //text veld na password
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Password bevestigen text
        Label pwb = new Label("Confirm Password :");
        grid.add(pwb, 0, 3);

        //text veld na password bevestigen
        PasswordField pwbBox = new PasswordField();
        grid.add(pwbBox, 1, 3);

        //De Sign in button
        Button btn = new Button("Sign in");
        btn.setPrefWidth(150);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //Registreert ook een enter
        btn.setDefaultButton(true);

        //Text die een foutmelding geeft
        final Text actiontarget = new Text();
        actiontarget.setFill(Color.FIREBRICK);
        grid.add(actiontarget, 1, 7);

        //primarystage
        primaryStage.setTitle(GlobalI.productNaam());
        Scene scene = new Scene(grid, 1200, 920);
        primaryStage.setScene(scene);
        //scene.getStylesheets().add("global/Style2.css");
        primaryStage.show();

        //action
        btn.setOnAction((javafx.event.ActionEvent e) -> {

            System.out.println("test");

            //kijkt of allebei de velden zijn ingevuld
            if (pwBox.getText().trim().isEmpty() || userTextField.getText().trim().isEmpty()) {
                actiontarget.setText("Password and/or username \ncan't be left open");
            } else {

                //get variable
                String gebruikersnaam = userTextField.getText();
                String wachtwoord = pwBox.getText();
                String wachtwoordBevestigen = pwBox.getText();

                //kijk of het wachtwoord veld het zelfde is
                if (wachtwoord.equals(wachtwoordBevestigen)) {

                    //encrypt de data
                    try {
                        //encrypt de data
                        String encryptData = encrypt.encrypt(wachtwoord, wachtwoord);
                        System.out.println(encryptData);
                        
                        //sla de data op
                        fileSystem.saveFile("wachtwoord.txt", encryptData);

                        //stuur de gebruiker door naar de volgende pagina
                    } catch (Exception ex) {
                        //set de text in de interface
                        actiontarget.setText("Probleem bij data de versleutelen of bestand op te slaan");
                    }
                } else {
                    actiontarget.setText("Password is not the same as Password Confurm.");
                }
            }
        });
    }
}
