/*
 * Home pagine
 */
package Interface;

import global.ConfigGetter;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author michel
 */
public class Home extends ConfigGetter {

    statestieken statestieken = new statestieken();

    /**
     * Deze methoden maakt een sreen aan
     *
     * @param primaryStage
     */
    public void homeScreen(Stage primaryStage) {

        //Hier wordt de menubar bovenin aangemaakt
        MenuBalk menuB = new MenuBalk();
        MenuBar menuBar = menuB.createMenuB(primaryStage);
        BorderPane root = new BorderPane();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        //gridpane
        GridPane grid = new GridPane();
        grid.setMaxSize(1200, 920);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        root.setCenter(grid);
        Scene scene = new Scene(root, 1200, 920);

        //Welkom + Letter type
        Label scenetitle = new Label("Welcome to " + programmaNaam);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 35, 0);

        
        

        Button btn1 = new Button("Go to statistics");
        btn1.setPrefWidth(150);
        GridPane.setConstraints(btn1, 0, 10);
        btn1.setOnAction((javafx.event.ActionEvent e) -> {
            statestieken.statisticScreen(primaryStage);
        });

        if (super.isLoadCss()) {
            scene.getStylesheets().add(super.getCssLocatie());
        }
        grid.getChildren().addAll(btn1);

        primaryStage.setTitle("Register Customer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
