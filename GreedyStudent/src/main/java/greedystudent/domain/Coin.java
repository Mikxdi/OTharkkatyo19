/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin extends ImageView {
    String coin = "images/coin.png";
    double size = 60;
    
    public Coin(double xpos, double ypos){
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(coin));
        setX(xpos);
        setY(ypos);
        setFitHeight(size);
        setFitWidth(size);
        setImage(image);
    }
}
