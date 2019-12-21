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
import greedystudent.dao.PlayerDao;
import greedystudent.domain.Player;
import javafx.scene.control.TextField;

        
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
    private Player player;
    private PlayerDao playerDao;
    
    @Override
    public void init() throws Exception {
        this.playerDao = new PlayerDao();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage mainstage) throws Exception {
        loginScreen(mainstage);
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
                if(current-lastpoint < 100000){
                    return;
                }
                if(!student.isAlive){
                    stop();
                    endGameLossScreen(s);
                }
                if(gamelog.allcoins == true){
                    stop();
                    player.setLevelsPassed(currentlevel);
                    playerDao.UpdatePlayer(player);
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
        main.setMinWidth(100);
        levelsm.setMinWidth(100);
        Label gz = new Label("You Won!");
        endPane.add(main, 0, 2);
        endPane.add(gz, 0, 0);
        endPane.add(levelsm, 0, 1);
        endPane.setAlignment(Pos.CENTER);
        endPane.setHgap(40);
        endPane.setVgap(40);
        endPane.setPadding(new Insets(30, 30, 30, 30));
        endBorder.setCenter(endPane);
        Scene end = new Scene(endBorder, width/2, height/2);
        s.setScene(end);
    }
    
    public void endGameLossScreen(Stage s){
        BorderPane endBorder = new BorderPane();
        GridPane endPane = new GridPane();
        Button main = new Button("Mainmenu");
        main.setOnAction(e ->{
            mainMenu(s);
        });
        Button retry = new Button("Retry");
        retry.setOnAction(e ->{
            gameLoop(s);
        });
        main.setMinWidth(100);
        retry.setMinWidth(100);
        Label gz = new Label("You Lost!");
        endPane.add(main, 0, 2);
        endPane.add(gz, 0, 0);
        endPane.add(retry, 0, 1);
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
        Button start = new Button("Start");
        start.setOnAction(e ->{
            levelMenu(s);
        });
        Button quitB = new Button("Quit");
        quitB.setOnAction(e ->{
            s.close();
        });
        quitB.setMinWidth(100);
        start.setMinWidth(100);
        startPane.add(start, 0, 0);
        startPane.add(quitB, 0, 1);
        startPane.setHgap(20);
        startPane.setVgap(20);
        startPane.setAlignment(Pos.CENTER);
        Scene alku = new Scene(startPane, width/2, height/2);
        s.setScene(alku);
    }
    
    public void levelMenu(Stage s){
        BorderPane levels = new BorderPane();
        Button level1 = new Button("1");
        Button level2 = new Button("2");
        Button level3 = new Button("3");
        Button back = new Button("Return");
        System.out.println(player.getLevelsPassed());
        HBox buttons = new HBox();
        level1.setOnAction(e ->{
            currentlevel=1;
            gameLoop(s);
        });
        if(this.player.getLevelsPassed()>0){
            level2.setOnAction(e ->{
                System.out.println(player.getLevelsPassed());
                currentlevel=2;
                gameLoop(s);
            });
        }
        if(this.player.getLevelsPassed()>1){
            level3.setOnAction(e ->{
                currentlevel=3;
                gameLoop(s);
            });
        }
        back.setOnAction(e ->{
            mainMenu(s);
        });
        level1.setMinWidth(100);
        level2.setMinWidth(100);
        level3.setMinWidth(100);
        buttons.getChildren().add(level1);
        buttons.getChildren().add(level2);
        buttons.getChildren().add(level3);
        buttons.setSpacing(50);
        levels.setCenter(buttons);
        back.setAlignment(Pos.BOTTOM_CENTER);
        levels.setBottom(back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(30, 30, 30, 30));
        Scene levelmenu = new Scene(levels, width/2, height/2);
        s.setScene(levelmenu);
    }
    
    public void loginScreen(Stage s){
        BorderPane loginB = new BorderPane();
        GridPane login = new GridPane();
        login.setAlignment(Pos.CENTER);
        TextField username = new TextField();
        Button loginbutton = new Button("Login");
        loginbutton.setOnAction(e ->{
            String name = username.getText();
            this.player = playerDao.addOrGetPlayer(name);
            mainMenu(s);
        });
        login.add(username, 2, 2);
        login.add(loginbutton, 2, 3);
        loginB.setCenter(login);
        Scene loginMenu = new Scene(loginB, width/2, height/2);
        s.setScene(loginMenu);
    }
}
