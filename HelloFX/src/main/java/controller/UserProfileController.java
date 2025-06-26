package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import util.GlobalState;

import java.io.IOException;

public class UserProfileController extends BaseController{
    @FXML
    private Label nameLabel;

    @FXML
    private Button logoutButton;

    @FXML
    public void displayName(String username) {
        nameLabel.setText("Hello: " + username);
    }

    @FXML
    public void logout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to log out");
        alert.setContentText("Do you want to save bfore exiting?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            LoginController loginController = (LoginController) sceneController.switchTo(GlobalState.LOGIN_FILE);
            loginController.resetTextField();
        }
    }
}
