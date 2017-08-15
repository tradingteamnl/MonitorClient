/*
 * Balance selecteer pagina
 */
package Interface.balance;

import Interface.MenuBalk;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author michel
 */
public class BalanceMain {

    /**
     * Select classe om aan te geven welke exchange allemaal moet laten zien
     *
     * @param primaryStage interface
     */
    public void balanceMain(Stage primaryStage) {

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

        //voeg buttons toe
        Text selecteerData = new Text("Select exchange");
        selecteerData.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        grid.add(selecteerData, 0, 1, 2, 1);

        //bittrex
        Label amsterdamAirportLabel = new Label("Schiphol, Amsterdam");
        grid.add(amsterdamAirportLabel, 9, 2);
        CheckBox amsterdamAirport = new CheckBox();
        grid.add(amsterdamAirport, 10, 2);

        //poloniex
        //kijk of css geladen mag worden
        /*if (super.isLoadCss()) {
            scene.getStylesheets().add(super.getCssLocatie());
        }*/
        //laat zien primarystage
        primaryStage.setTitle("Balance select");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
