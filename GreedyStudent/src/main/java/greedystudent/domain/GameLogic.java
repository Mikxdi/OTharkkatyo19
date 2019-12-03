/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;

import java.util.ArrayList;
import javafx.geometry.Bounds;

/**
 *
 * @author lehtmikk
 */
public class GameLogic {
    public Level l;
    public Character c;
    public boolean allcoins = false;
    public GameLogic(Character c, Level l){
        this.l = l;
        this.c = c;
    }
    
    public void update(){
        charMovementX();
        charMovementY();
        checkCoins();
        aliveStatus();
    }
    
    public void charMovementX(){
        if(c.movingLeft == true){
            c.setX(c.getX() - 5);
        }
        if(c.movingRight == true){
            c.setX(c.getX() + 5);
        }
        for (Platform plat : l.getPlatformList()) {
            Bounds bounds = plat.getLayoutBounds();
            if (c.intersects(bounds)) {
                if (c.movingRight) {
                    c.setX(bounds.getMinX() - c.size - 0.0001);
                }
                if (c.movingLeft) {
                    c.setX(bounds.getMaxX() + 0.01);
                }
            }
        }
        if(c.getX()<0){
            c.setX(0);
        }
        if(c.getX()> 1200){
            c.setX(1190);
        }
    }    
    
    public void charMovementY(){
       c.yVelocity += c.yAccelerate;
       c.setY(c.getY() + c.yVelocity);
       c.onPlatform = false;
       for(Platform plat : l.getPlatformList()){
           Bounds bounds = plat.getLayoutBounds();
           if(c.intersects(bounds)){
               c.setY(bounds.getMinY() - c.size-0.0001);
               c.canJump = true;
               c.yVelocity= 0;
               c.yAccelerate = 0;
               c.onPlatform = true;
           }
       }
       if(!c.onPlatform){
           c.yAccelerate = 1.0001;
       }
    }    
    
    public void checkCoins(){
        ArrayList<Coin> removableCoins = new ArrayList<>();
        for(Coin coins : l.getCoinList()){
           Bounds bounds = coins.getLayoutBounds();
           if(c.intersects(bounds)){
               removableCoins.add(coins);
           }
        }
        l.getCoinList().removeAll(removableCoins);
        l.getChildren().removeAll(removableCoins);
        if(l.getCoinList().isEmpty()){
            allcoins=true;
        }
        
    }
    public void aliveStatus(){
        if(c.getY()> 2000){
            c.isAlive = false;
        }
    }
}
