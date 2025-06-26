package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class DatePickerController extends BaseController implements Initializable {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myLabel;

    @FXML
    private ColorPicker myColorPicker;

    @FXML
    private Pane myPane;

    @FXML
    private ChoiceBox <String> myChoiceBox;

    private String [] food = {"Pizza", "Burger", "Pasta", "Salad", "Sushi"};

    @FXML
    private Slider mySlider;

    int myTemperature;

    @FXML
    private Button increaseProgressBtn;

    @FXML
    private ProgressBar myProgressBar;

    double progress = 0.5;

    @FXML
    private Spinner<Integer> mySpinner;

    @FXML
    private Label spinnerLabel;

    int spinnerValue = 0;


    public void handleMyDatePicker(ActionEvent e) throws IOException {
        if (myDatePicker.getValue() != null) {
            LocalDate myDate = myDatePicker.getValue();
            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            myLabel.setText(myFormattedDate);
        } else {
            myLabel.setText("No date selected");
        }
    }

    public void handleMyColorPicker(ActionEvent e) throws IOException {
        if (myColorPicker.getValue() != null) {
            Color myColor = myColorPicker.getValue();
            myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(food);
        myChoiceBox.setOnAction(this::handleMyChoiceBox);

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                myTemperature = (int) mySlider.getValue();
                myLabel.setText("Temperature: " + Integer.toString(myTemperature) + " Degress Celcius");
            }
        });

        myProgressBar.setStyle("-fx-accent: green;");



        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);

        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);

        spinnerValue = mySpinner.getValue();
        spinnerLabel.setText(Integer.toString(spinnerValue));

        mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                spinnerValue = mySpinner.getValue();
                spinnerLabel.setText(Integer.toString(spinnerValue));
            }
        });
    }

    public void handleMyChoiceBox(ActionEvent e){
        String selectedFood = myChoiceBox.getValue();
        if (selectedFood != null) {
            myLabel.setText("Selected food: " + selectedFood);
        } else {
            myLabel.setText("No food selected");
        }
    }

    public void handleIncreaseProgressBtn(ActionEvent e) {
        progress += 0.1;
        if (progress > 1.0) {
            progress = 1.0; // Cap the progress at 100%
        }
        myProgressBar.setProgress(progress);
    }


}
