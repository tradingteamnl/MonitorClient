/*
 * Settings pagina
 */
package Interface;

import global.FileSystem;
import global.LoadSettings;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author michel
 */
public class Setting {

    //maak object
    FileSystem fileSystem = new FileSystem();
    LoadSettings loadSettings;
    boolean succesvolOpgestart = false;

    //boolean bittrexSelect
    private boolean bittrexSelect = false;
    private boolean poloniexSelect = false;

    //ArrayList
    private ArrayList<String> selectExchangeList = new ArrayList<String>();

    /**
     * laat bollean setting
     */
    public Setting() {
        //maak object load settings
        try {
            this.loadSettings = new LoadSettings();
            this.succesvolOpgestart = true;
        } catch (IOException ex) {
            this.succesvolOpgestart = false;
            System.err.println("[ERROR] [SETTINGS] De construtor is niet succesvol uitgevoegd! Dit is de error \n" + ex);
        }

        //vul die boolean
        this.bittrexSelect = loadSettings.isLoadBittrex();
        this.poloniexSelect = loadSettings.isLoadPoloniex();
    }

    /**
     * Settings pagina
     *
     * @param primaryStage interface
     */
    public void setting(Stage primaryStage) {

        //Hier wordt de menubar bovenin aangemaakt
        MenuBalk menuB = new MenuBalk();
        MenuBar menuBar = menuB.createMenuB(primaryStage);
        BorderPane root = new BorderPane();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        //gridpane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        root.setCenter(grid);
        Scene scene = new Scene(root, 1200, 920);

        //rij
        int rij = 0;

        //Label titel
        Label titeLabel = new Label("Select exchange");
        grid.add(titeLabel, 0, rij++);

        //Bittrex label
        Label bittrexLabel = new Label("Bittrex");
        grid.add(bittrexLabel, 1, rij);

        //CheckBox bittrex
        CheckBox bittrexCheckbox = new CheckBox();

        //kijk of de checkbox true of false moet zijn
        bittrexCheckbox.setSelected(loadSettings.isLoadBittrex());
        grid.add(bittrexCheckbox, 0, rij++);

        //Poloniex label
        Label poloniexLabel = new Label("Poloniex");
        grid.add(poloniexLabel, 1, rij);

        //CheckBox bittrex
        CheckBox poloniexCheckbox = new CheckBox();
        poloniexCheckbox.setSelected(loadSettings.isLoadPoloniex());
        grid.add(poloniexCheckbox, 0, rij++);

        //button
        Button editButton = new Button("Edit");
        grid.add(editButton, 1, rij);

        //laat zien primarystage
        primaryStage.setTitle("Balance select");
        primaryStage.setScene(scene);
        primaryStage.show();

        /* ===================== action event ===================== */
        //bittrex checkbox
        bittrexCheckbox.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            bittrexSelect = new_val;
            if (bittrexSelect) {

                //zet bittrex select op true
                this.bittrexSelect = true;
                System.out.println("[INFO] [SETTING] Variable bittrexSelect is geupdate.");

            } else {

                //zet bittrexSelect op false
                this.bittrexSelect = false;
                System.out.println("[INFO] [SETTING] Variable bittrexSelect is geupdate.");

            }
        });

        //poloniex checkbox
        poloniexCheckbox.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            poloniexSelect = new_val;
            if (poloniexSelect) {

                //zet poloniexSelect op true
                this.poloniexSelect = true;
                System.out.println("[INFO] [SETTING] Variable poloniexSelect is geupdate.");

            } else {

                //zet poloniexSelect op false
                this.poloniexSelect = false;
                System.out.println("[INFO] [SETTING] Variable poloniexSelect is geupdate.");
            }
        });

        //button om alle onderdelen op te slaan
        editButton.setOnAction((ActionEvent e) -> {
            //laat methoden save input
            saveInput();
        });
    }

    /**
     * Deze methoden slaat alle data op
     */
    private void saveInput() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            //file output
            output = new FileOutputStream(fileSystem.saveLocation()+"settingsFile.properties");

            // set the properties value
            prop.setProperty("bittrex", ""+bittrexSelect);
            prop.setProperty("poloniex", ""+poloniexSelect);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
