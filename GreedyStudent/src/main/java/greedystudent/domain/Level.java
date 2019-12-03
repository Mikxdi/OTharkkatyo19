/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;
import javafx.scene.Group;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author lehtmikk
 */
public class Level extends Group {
    private int freeId = 0;
    private int platId = 1;
    private int coinId = 2;
    private int levelPlatWidth = 20;
    private int levelPlatHeight = 8;
    private double levelHeight, levelWidth;
    private double widthR = 0.7;
    private List<Platform> platList;
    private String lvl = "levels/level1.txt";
    private List<Coin> coinList;
    
    public Level(double height) {
        String file = lvl;
        InputStream fileread = getClass().getClassLoader().getResourceAsStream(file);
        Scanner lvlinput = new Scanner(fileread);
        platList = new ArrayList<Platform>();
        coinList = new ArrayList<Coin>();
        levelHeight = height;
        levelWidth = (double) (levelPlatWidth) / levelPlatHeight * levelHeight * widthR;
        double platHeight = levelHeight / levelPlatHeight;
        double platWidth = platHeight * widthR;
        for (int y = 0; y < levelPlatHeight; y++) {
            for (int x = 0; x < levelPlatWidth; x++) {
                int id = lvlinput.nextInt();
                if (id == freeId) {
                    continue;
                } else if (id == platId) {
                    Platform plat = new Platform(x * platWidth, y * platHeight, platWidth, platHeight);
                    getChildren().add(plat);
                    platList.add(plat);
                } else if (id == coinId) {
                    Coin coin = new Coin(x * platWidth, y * platHeight);
                    getChildren().add(coin);
                    coinList.add(coin);
                }
                
            }
        }
    }
    public List<Platform> getPlatformList() {
        return platList;
    }
    public List<Coin> getCoinList() {
        return coinList;
    }
    double getHeigth() {
        return levelHeight;
    }
    double getWidth() {
        return levelWidth;
    }
}
