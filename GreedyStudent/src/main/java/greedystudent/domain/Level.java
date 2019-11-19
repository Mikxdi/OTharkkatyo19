/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;
import java.io.IOException;
import javafx.scene.Group;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;


/**
 *
 * @author lehtmikk
 */
public class Level extends Group{
    private int freeId = 0;
    private int platId = 1;
    private int levelPlatWidth = 20;
    private int levelPlatHeight = 8;
    private double levelHeight, levelWidth;
    private double widthR = 0.7;
    private List <Platform> platList;
    private String lvl = "levels/level1.txt";
    
    public Level(double height){
        System.out.println("onnistuu1");
        String file = lvl;
        InputStream fileread = getClass().getClassLoader().getResourceAsStream(file);
        System.out.println("onnistuu2");
        Scanner lvlinput = new Scanner(fileread);
        System.out.println("onnistuu3");
        platList = new ArrayList<Platform>();
        levelHeight = height;
        levelWidth = (double) (levelPlatWidth)/levelPlatHeight*levelHeight*widthR;
        double platHeight = levelHeight/levelPlatHeight;
        double platWidth =platHeight*widthR;
        for(int y = 0; y < levelPlatHeight; y++){
            System.out.println("onnistuispa");
            for(int x = 0; x < levelPlatWidth; x++){
                int id = lvlinput.nextInt();
                if(id == freeId){
                    continue;
                }else if(id == platId){
                    System.out.println("lisää");
                    Platform plat = new Platform(x*platWidth, y*platHeight, platWidth, platHeight);
                    getChildren().add(plat);
                    platList.add(plat);
                }
                
            }
        }
    }
    public List <Platform> getPlatformList(){
        return platList;
    }
    double getHeigth(){
        return levelHeight;
    }
    double getWidth(){
        return levelWidth;
    }
}
