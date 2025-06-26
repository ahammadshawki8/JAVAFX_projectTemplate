package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class RadioButtonController extends BaseController {

    @FXML
    private Label subTitle;

    @FXML
    private RadioButton rButton1, rButton2, rButton3;
    @FXML
    private void handleRButton(ActionEvent e) throws IOException {
        if (rButton1.isSelected()) {
            subTitle.setText(rButton1.getText() );
        } else if (rButton2.isSelected()) {
            subTitle.setText(rButton2.getText() );
        } else if (rButton3.isSelected()) {
            subTitle.setText(rButton3.getText() );
        } else {
            subTitle.setText("No selection");
        }
    }
}
