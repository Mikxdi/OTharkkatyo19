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
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.util.ArrayList;
import greedystudent.domain.Level;

        
/**
 *
 * @author lehtmikk
 */
public class GreedystudentUi extends Application {
    private double height =720;
    private double width = 1280;
    private Group sceneGroup;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        GridPane e = new GridPane();
        Button start = new Button("start");
        e.add(start, 1, 1);
        sceneGroup = new Group();
        Scene alku = new Scene(sceneGroup, height, width);
        Level cLevel = new Level(height);
        sceneGroup.getChildren().add(cLevel);
        stage.setScene(alku);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.show();
    }
}
