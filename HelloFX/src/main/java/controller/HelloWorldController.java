package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.GlobalState;

import java.io.IOException;


public class HelloWorldController extends BaseController {
    @FXML
    private void handleClickMeBtn(ActionEvent e) throws IOException {
        sceneController.switchTo(GlobalState.EVENT_HANDLING_FILE);
    }
}
