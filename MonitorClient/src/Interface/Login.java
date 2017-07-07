/*
 * Login javafx
 */
package Interface;

//import
import InterfaceMethoden.InlogControle;
import InterfaceMethoden.InterfaceGlobal;
import Security.Decrypt;
import global.ConfigGetter;
import global.FileSystem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * @author Jaros
 */
public class Login extends ConfigGetter {

    //maak objecten aan
    InlogControle InlogControle = new InlogControle();
    InterfaceGlobal GlobalI = new InterfaceGlobal();
    InlogControle inlogControle = new InlogControle();
    FileSystem FileSystem = new FileSystem();
    Decrypt Decrypt = new Decrypt();

    public void loginScherm(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Welkom + Letter type
        Text scenetitle = new Text("Welcome To " + GlobalI.productNaam());
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

        //De Sign in button
        Button btn = new Button("Sign in");
        btn.setPrefWidth(150);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);

        //Registreert ook een enter
        btn.setDefaultButton(true);

        //Text die een foutmelding geeft
        final Text actiontarget = new Text();
        actiontarget.setFill(Color.FIREBRICK);
        grid.add(actiontarget, 1, 4);

        primaryStage.setTitle(GlobalI.productNaam());
        Scene scene = new Scene(grid, 1200, 920);
        primaryStage.setScene(scene);
        primaryStage.show();

        //kijk of css geladen mag worden
        if (super.isLoadCss()) {
            scene.getStylesheets().add(super.getCssLocatie());
        }

        //action
        btn.setOnAction((javafx.event.ActionEvent e) -> {
            boolean check = false;
            String gebruikersnaam = userTextField.getText();
            String wachtwoord = pwBox.getText();
            try {
                check = Login(gebruikersnaam, wachtwoord);
                /*<<<<<<< HEAD
                String Gebruikersnaam = userTextField.getText();
                String Wachtwoord = pwBox.getText();
                boolean check = inlogControle.getLogin(Gebruikersnaam, Wachtwoord);
                if (check) {
                //ga naar home
                GlobalI.setGebruiker(Gebruikersnaam);
                } else {
                userTextField.setText("");
                pwBox.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);    // get an alert popup
                alert.setTitle("warning");
                alert.setHeaderText("username and/or password are incorrect");
                alert.showAndWait();*/
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            //boolean check = InlogControle.getLogin(gebruikersnaam, wachtwoord);
            //kijk of het true is
            if (check) {

                //maak object aan
                Home home = new Home();

                //stuur de gebruiker door naar de nieuwe pagina
                home.homeScreen(primaryStage);
            } else {
                System.err.println("Log in fout");
            }

        }
        );
    }

    private boolean Login(String naam, String wachtwoord) throws IOException {
        String encrypt = FileSystem.readFile("wachtwoord.txt");
        
                
        boolean check = false;

        return check;
    }
}
