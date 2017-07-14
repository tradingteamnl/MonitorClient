/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import global.ConfigGetter;
import java.awt.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jaros
 */
public class statestieken extends ConfigGetter {

    public void statisticScreen(Stage primaryStage) {

        //Hier wordt de menubar bovenin aangemaakt
        MenuBalk menuB = new MenuBalk();
        MenuBar menuBar = menuB.createMenuB(primaryStage);
        BorderPane root = new BorderPane();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);
        GridPane grid = new GridPane();
        grid.setMaxSize(1200, 920);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        root.setCenter(grid);
        Scene scene = new Scene(root, 1200, 920);

        Button btn = new Button("doe iets");
        btn.setPrefWidth(150);
        GridPane.setConstraints(btn, 0, 0);
        btn.setOnAction((javafx.event.ActionEvent e) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("test");
            alert.setHeaderText("De knop werkt :P");
            alert.showAndWait();
        });
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Totaal kapitaal");
        GridPane.setConstraints(chart, 40, 1);

        grid.getChildren().addAll(btn, chart);

        primaryStage.setTitle("Statistics screen");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
