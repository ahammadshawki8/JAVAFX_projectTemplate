package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;


public class CheckBoxController extends BaseController {
    @FXML
    private CheckBox myCheckBox;

    @FXML
    private ImageView myImageView;

    Image onImage = new Image(ImageViewController.class.getResourceAsStream("/images/bulb_on.jpg"));
    Image offImage = new Image(ImageViewController.class.getResourceAsStream("/images/bulb_off.jpg"));


    @FXML
    private void change(ActionEvent e) throws IOException {
        if (myCheckBox.isSelected()) {
            myImageView.setImage(onImage);
            myCheckBox.setText("Light On");
        } else {
            myImageView.setImage(offImage);
            myCheckBox.setText("Light Off");
        }
    }


}
