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
    public double size = 100;
    public String character = "images/student.png";
    public double xSpeed = 300;
    public double jumpHeight = 30;
    public boolean canJump =  false;
    public double yAccelerate = 1.0001;
    public boolean movingRight;
    public boolean movingLeft;
    public double yVelocity;
    public boolean onPlatform = false;
    public boolean isAlive = true;
    
    
    public Character(double xpos, double ypos) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(character));
        setX(xpos);
        setY(ypos);
        setFitHeight(size);
        setFitWidth(size);
        setImage(image);
    }
    public void moveLeft() {
        movingRight = false;
        movingLeft = true;
    }
    public void moveRight() {
        movingRight = true;
        movingLeft = false;
    }
    public void stopMovementX() {
        movingRight = false;
        movingLeft = false;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }
    public void jump() {
        if (canJump) {
            yVelocity -= jumpHeight;
            yAccelerate = 1.0001;
        }
        canJump = false;
    }
    
}
