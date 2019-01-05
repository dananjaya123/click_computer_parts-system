package lk.ijse.gdse.computerParts.css;

import javafx.animation.ScaleTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class OtherMethord {
    public static void imageDashboard(ImageView image, double d) {
        ScaleTransition temp = new ScaleTransition(Duration.millis(300), image);
        temp.setToX(d);
        temp.setToY(d);
        temp.play();

    }

}
