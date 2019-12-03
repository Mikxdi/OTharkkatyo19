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
import greedystudent.domain.Character;
import greedystudent.domain.GameLogic;
import javafx.animation.AnimationTimer;

        
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
    public void start(Stage mainstage) throws Exception {
        GridPane er = new GridPane();
        Button start = new Button("start");
        start.setOnAction(e ->{
            gameLoop(mainstage);
        });
        er.add(start, 0, 0);
        /*sceneGroup = new Group();
        Scene game = new Scene(sceneGroup,width, height);
        Level cLevel = new Level(height);
        Character student = new Character(0, 0);
        sceneGroup.setLayoutX(0);
        sceneGroup.getChildren().add(cLevel);
        sceneGroup.getChildren().add(student);*/
        Scene alku = new Scene(er, width, height);
        mainstage.setScene(alku);
        mainstage.show();
    }
    
    public void gameLoop(Stage s){
        sceneGroup = new Group();
        Scene game = new Scene(sceneGroup,width, height);
        Level cLevel = new Level(height);
        Character student = new Character(0, 0);
        GameLogic gamelog = new GameLogic(student, cLevel);
        sceneGroup.setLayoutX(0);
        sceneGroup.getChildren().add(cLevel);
        sceneGroup.getChildren().add(student);
        s.setScene(game);
        new AnimationTimer(){
            long lastpoint=0;
            
            
            @Override
            public void handle(long current){
                if(current-lastpoint < 1000){
                    return;
                }
                game.setOnKeyPressed(e ->{
                    if(e.getCode() == KeyCode.D){
                        student.moveRight();
                    }
                    if(e.getCode() == KeyCode.A){
                        student.moveLeft();
                    }
                });
                gamelog.update();
                lastpoint = current;
            }
        }.start();
    }
}
