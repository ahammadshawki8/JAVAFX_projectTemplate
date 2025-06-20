package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import util.GlobalState;

import java.io.IOException;

public class LoginController extends BaseController{

    @FXML
    TextField nameTextField;

    @FXML
    public void login(ActionEvent e) throws IOException {
        String username = nameTextField.getText();

        UserProfileController userProfileController = (UserProfileController) sceneController.switchTo(GlobalState.USER_PROFILE_FILE);
        userProfileController.displayName(username);
    }

    @FXML void resetTextField() {
        nameTextField.setText("");
    }
}
