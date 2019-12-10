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
import greedystudent.domain.Student;
import greedystudent.domain.GameLogic;
import java.util.HashSet;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

        
/**
 *
 * @author lehtmikk
 */
public class GreedystudentUi extends Application {
    private double height =720;
    private double width = 1280;
    private Group sceneGroup;
    private HashSet<KeyCode> pressed;
    private int currentlevel;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage mainstage) throws Exception {
        mainMenu(mainstage);
        mainstage.setTitle("GreedyStudent");
        mainstage.show();
    }
    
    public void gameLoop(Stage s){
        sceneGroup = new Group();
        Scene game = new Scene(sceneGroup,width, height);
        Level cLevel = new Level(height, currentlevel);
        Student student = new Student(0, 0);
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
                    endGameLossScreen(s);
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
        BorderPane endBorder = new BorderPane();
        GridPane endPane = new GridPane();
        Button main = new Button("mainmenu");
        main.setOnAction(e ->{
            mainMenu(s);
        });
        Button levelsm = new Button("Levels");
        levelsm.setOnAction(e ->{
            levelMenu(s);
        });
        Label gz = new Label("You Won!");
        endPane.add(main, 0, 1);
        endPane.add(gz, 0, 0);
        endPane.add(levelsm, 0, 2);
        endPane.setAlignment(Pos.CENTER);
        endPane.setHgap(20);
        endPane.setVgap(20);
        endPane.setPadding(new Insets(30, 30, 30, 30));
        endBorder.setCenter(endPane);
        Scene end = new Scene(endBorder, width/2, height/2);
        s.setScene(end);
    }
    
    public void endGameLossScreen(Stage s){
        BorderPane endBorder = new BorderPane();
        GridPane endPane = new GridPane();
        Button main = new Button("Back to mainmenu");
        main.setOnAction(e ->{
            mainMenu(s);
        });
        Button retry = new Button("retry");
        retry.setOnAction(e ->{
            gameLoop(s);
        });
        Label gz = new Label("You Lost!");
        endPane.add(main, 0, 1);
        endPane.add(gz, 0, 0);
        endPane.add(retry, 0, 2);
        endPane.setAlignment(Pos.CENTER);
        endPane.setHgap(40);
        endPane.setVgap(40);
        endPane.setPadding(new Insets(30, 30, 30, 30));
        endBorder.setCenter(endPane);
        Scene end = new Scene(endBorder, width/2, height/2);
        s.setScene(end);
    }
    
    public void mainMenu(Stage s){
        GridPane startPane = new GridPane();
        Button start = new Button("start");
        start.setOnAction(e ->{
            levelMenu(s);
        });
        startPane.add(start, 0, 0);
        startPane.setAlignment(Pos.CENTER);
        Scene alku = new Scene(startPane, width/2, height/2);
        s.setScene(alku);
    }
    
    public void levelMenu(Stage s){
        BorderPane levels = new BorderPane();
        Button level1 = new Button("1");
        Button level2 = new Button("2");
        Button level3 = new Button("3");
        Button back = new Button("return");
        HBox buttons = new HBox();
        level1.setOnAction(e ->{
            currentlevel=1;
            gameLoop(s);
        });
        level2.setOnAction(e ->{
            currentlevel=2;
            gameLoop(s);
        });
        level3.setOnAction(e ->{
            currentlevel=3;
            gameLoop(s);
        });
        back.setOnAction(e ->{
            mainMenu(s);
        });
        buttons.getChildren().add(level1);
        buttons.getChildren().add(level2);
        buttons.getChildren().add(level3);
        buttons.setSpacing(50);
        levels.setCenter(buttons);
        levels.setBottom(back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(30, 30, 30, 30));
        Scene levelmenu = new Scene(levels, width/2, height/2);
        s.setScene(levelmenu);
    }
}
