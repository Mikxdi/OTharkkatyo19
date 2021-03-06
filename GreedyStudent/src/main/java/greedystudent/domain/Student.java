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
 *Class for creating playable character for game
 */
public class Student extends ImageView {
    public double size = 100;
    public String character = "images/student.png";
    public double xSpeed = 300;
    public double jumpHeight = 30;
    public boolean canJump =  false;
    public double yAccelerate = 1.000001;
    public boolean movingRight = false;
    public boolean movingLeft = false;
    public double yVelocity;
    public boolean onPlatform = false;
    public boolean isAlive = true;
    
    /**
     * Creates character to given position
     * @param xpos
     * @param ypos 
     */
    public Student(double xpos, double ypos) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(character));
        setX(xpos);
        setY(ypos);
        setFitHeight(size);
        setFitWidth(size);
        setImage(image);
    }
    /**
     * Move command to left
     */
    public void moveLeft() {
        movingRight = false;
        movingLeft = true;
    }
    /**
     * Move command to right
     */
    public void moveRight() {
        movingRight = true;
        movingLeft = false;
    }
    /**
     * Stops movevent if no button presses happen
     */
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
    /**
     * Checks if character can jump and sets jump velocity and acceleration
     * if false nothing happens
     */
    public void jump() {
        if (canJump) {
            yVelocity -= jumpHeight;
            yAccelerate = 1.000001;
        }
        canJump = false;
    }
    
}
