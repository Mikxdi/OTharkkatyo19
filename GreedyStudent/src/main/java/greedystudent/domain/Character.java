/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/**
 *
 * @author lehtmikk
 */
public class Character extends ImageView {
    private double size = 100;
    private String character = "images/student.png";
    private double xSpeed = 300;
    private double jumpHeight = 700;
    private boolean canJump;
    private double yAccelerate;
    public boolean movingRight;
    public boolean movingLeft;
    
    
    public Character(double xpos, double ypos) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(character));
        setX(xpos);
        setY(ypos);
        setFitHeight(size);
        setFitWidth(size);
        setImage(image);
        canJump = true;
    }
    public void moveLeft() {
        movingRight = false;
        movingLeft = true;
    }
    public void moveRight() {
        movingRight = true;
        movingLeft = false;
    }
   
    
}
