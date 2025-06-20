package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewController extends BaseController {

    @FXML
    ImageView myImageView;

    @FXML
    Button myButton;

    private int imageIndex = 0;

    Image myImage1 = new Image(ImageViewController.class.getResourceAsStream("/images/shrek1.jpg"));
    Image myImage2 = new Image(ImageViewController.class.getResourceAsStream("/images/shrek2.jpg"));

    public void displayImage() {
        if (imageIndex == 0) {
            myImageView.setImage(myImage1);
        } else {
            myImageView.setImage(myImage2);
        }
        imageIndex = 1 - imageIndex;
    }
}
