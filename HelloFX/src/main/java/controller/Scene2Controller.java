package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.GlobalState;
import java.io.IOException;

public class Scene2Controller extends BaseController {
    @FXML
    public void moveToScene1(ActionEvent e) throws IOException {
        sceneController.switchTo(GlobalState.SCENE_1_FILE);
    }
}
