/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;

/**
 *
 * @author lehtmikk
 */
public class GameLogic {
    private Level l;
    private Character c;
    public GameLogic(Character c, Level l){
        this.l = l;
        this.c = c;
    }
    
    public void update(){
        charMovementX();
    }
    
    public void charMovementX(){
        if(c.movingLeft == true){
            c.setX(c.getX() - 10);
        }
        if(c.movingRight == true){
            c.setX(c.getX() + 10);
        }
    }    
    
    public void charMovementY(){
        if()
    }    
}
