/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.ui;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

        
/**
 *
 * @author lehtmikk
 */
public class GreedystudentUi extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        GridPane e = new GridPane();
        Button start = new Button("start");
        e.add(start, 1, 1);
        Scene alku = new Scene(e);
        stage.setScene(alku);
        stage.show();
    }
}
