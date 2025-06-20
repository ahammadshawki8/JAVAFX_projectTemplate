package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class SceneBuilderTwo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL rootURL = getClass().getResource("/fxml/sceneBuilder.fxml");
        if (rootURL == null) {
            throw new RuntimeException("FXML resource not found");
        }
        Parent root = FXMLLoader.load(rootURL);


        Scene scene = new Scene(root);

        URL iconURL = getClass().getResource("/images/brand.png");
        if (iconURL == null) {
            throw new RuntimeException("Icon resource not found");
        }
        Image icon = new Image(iconURL.toExternalForm());

        stage.setTitle("Hello World");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }
}