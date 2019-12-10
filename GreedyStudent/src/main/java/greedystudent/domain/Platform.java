/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * Creates platform object for level class
 */
public class Platform extends Rectangle {
    private Color platcolor = Color.BROWN;
    /**
     * Creates rectangle with given position
     * @param x position in x 
     * @param y position in y
     * @param width platforms width
     * @param height platforms heigth
     */
    public Platform(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFill(platcolor);
    }
}
