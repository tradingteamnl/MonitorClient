/*
 * Home pagine
 */
package Interface;

import global.ConfigGetter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class Home extends ConfigGetter{

    /**
     * Deze methoden maakt een sreen aan
     *
     * @param primaryStage
     */
    public void homeScreen(Stage primaryStage){

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

        //Welkom + Letter type
        Text scenetitle = new Text("Welcome To ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        
        //kijk of css geladen mag worden
        if(super.isLoadCss()){
            scene.getStylesheets().add(super.getCssLocatie());
        }
        
        
        primaryStage.setTitle("Register Customer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
