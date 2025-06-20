package hellofx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class StageTutorialZero extends Application {
    // This method extends the Application class to create a JavaFX application.
    // Application class is an abstract class that provides the main entry point for JavaFX applications.

    public static void main(String[] args) {
        launch(args); // This method launches the JavaFX stage and initializes the application.
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        // This creates a root node for the scene graph.

        Scene scene = new Scene(root, Color.BLACK);
        // This creates a new scene with the specified root node and background color.

        URL iconUrl = getClass().getResource("/images/brand.png");
        // This retrieves the URL of the icon image from the resources folder.

        if (iconUrl == null) {
            throw new IllegalArgumentException("Image not found!");
        } // handle the case where the image is not found to avoid warnings or errors.

        Image icon = new Image(iconUrl.toExternalForm());
        // This creates an Image object from the URL of the icon image.
        // The toExternalForm() method converts the URL to a string that can be used to create an Image object.

        stage.getIcons().add(icon);
        // This adds the icon image to the stage's icon list, which will be displayed in the window's title bar.


        // stage settings
        stage.setTitle("Hello World");
        stage.setWidth(420);
        stage.setHeight(300);
        stage.setResizable(false);
//        stage.setX(50);
//        stage.setY(50);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("YOU CANT ESCAPE unless you press q");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));


        stage.setScene(scene); // This sets the scene for the stage, which contains the root node and its children.
        stage.show(); // This displays the stage (window) on the screen.
    }
}