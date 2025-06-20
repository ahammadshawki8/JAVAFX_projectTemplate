module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens hellofx to javafx.fxml;
    opens controller to javafx.fxml;

    exports hellofx;
    exports controller;
}
