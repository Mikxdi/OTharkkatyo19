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
 * @author lehtmikk
 */
public class Platform extends Rectangle {
    private Color platcolor = Color.BROWN;
    public Platform (double x, double y, double width, double height){
        super(x, y, width, height);
        setFill(platcolor);
    }
}
