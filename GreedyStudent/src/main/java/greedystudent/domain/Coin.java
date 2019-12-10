
package greedystudent.domain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * Class for coin objects in game
 */
public class Coin extends ImageView {
    String coin = "images/coin.png";
    double size = 60;
    /**
     * Creates coin object with given image and parameters
     * @param xpos sets coins x position
     * @param ypos sets coins y position
     */
    public Coin(double xpos, double ypos) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(coin));
        setX(xpos);
        setY(ypos);
        setFitHeight(size);
        setFitWidth(size);
        setImage(image);
    }
}
