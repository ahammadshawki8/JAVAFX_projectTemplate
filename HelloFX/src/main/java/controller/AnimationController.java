package controller;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimationController extends BaseController implements Initializable {

    @FXML
    private ImageView myImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setNode(myImage);
        translate.setByX(250);
        translate.setAutoReverse(true);
        translate.play();

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setNode(myImage);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.play();

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setNode(myImage);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();

        ScaleTransition scale = new ScaleTransition();
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setNode(myImage);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(1.5);
        scale.setByY(1.5);
        scale.play();
    }
}
