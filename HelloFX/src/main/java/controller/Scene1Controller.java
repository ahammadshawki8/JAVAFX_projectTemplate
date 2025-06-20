package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.GlobalState;
import java.io.IOException;

public class Scene1Controller extends BaseController{

    @FXML
    public void moveToScene2(ActionEvent e) throws IOException {
        sceneController.switchTo(GlobalState.SCENE_2_FILE);
    }
}
