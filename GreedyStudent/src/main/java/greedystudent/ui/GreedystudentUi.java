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
import java.util.HashSet;
import javafx.animation.AnimationTimer;

        
/**
 *
 * @author lehtmikk
 */
public class GreedystudentUi extends Application {
    private double height =720;
    private double width = 1280;
    private Group sceneGroup;
    private HashSet<KeyCode> pressed;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage mainstage) throws Exception {
        mainMenu(mainstage);
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
        pressed = new HashSet();
        s.setScene(game);
        
        new AnimationTimer(){
            long lastpoint=0;
            
            
            @Override
            public void handle(long current){
                if(current-lastpoint < 1000){
                    return;
                }
                if(!student.isAlive){
                    stop();
                    endGameScreen(s);
                }
                if(gamelog.allcoins == true){
                    stop();
                    endGameScreen(s);
                }
                game.setOnKeyPressed(e -> pressed.add(e.getCode()));
 
                if(pressed.contains(KeyCode.W)){
                        student.jump();
                }
                if(pressed.contains(KeyCode.D)){
                        student.moveRight();
                }
                if(pressed.contains(KeyCode.A)){
                        student.moveLeft();
                }
                game.setOnKeyReleased(e -> pressed.remove(e.getCode()));
                gamelog.update();
                student.stopMovementX();
                lastpoint = current;
            }
        }.start();
    }
    
    public void endGameScreen(Stage s){
        GridPane endPane = new GridPane();
        Button main = new Button("mainmenu");
        main.setOnAction(e ->{
            mainMenu(s);
        });
        endPane.add(main, 3, 3);
        Scene end = new Scene(endPane, width, height);
        s.setScene(end);
    }
    
    public void mainMenu(Stage s){
        GridPane er = new GridPane();
        Button start = new Button("start");
        start.setOnAction(e ->{
            gameLoop(s);
        });
        er.add(start, 0, 0);
        Scene alku = new Scene(er, width, height);
        s.setScene(alku);
    }
}
