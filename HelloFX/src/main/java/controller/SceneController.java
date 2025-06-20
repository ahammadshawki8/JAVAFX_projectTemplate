package controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.HashMap;

public class SceneController {
    private final Stage stage;
    private final HashMap<String, Scene> sceneMap = new HashMap<>();
    private final HashMap<String, Object> controllerMap = new HashMap<>();

    public SceneController(Stage primaryStage) {
        this.stage = primaryStage;
    }

    // Modified to accept controller too
    public void addScene(String name, Parent root, Object controller) {
        Scene scene = new Scene(root);

        URL cssFile = getClass().getResource("/styles/main.css");
        if (cssFile != null) {
            scene.getStylesheets().add(cssFile.toExternalForm());
        }

        sceneMap.put(name, scene);
        controllerMap.put(name, controller);
    }


    public Object switchTo(String name) {
        Scene scene = sceneMap.get(name);
        if (scene == null) {
            throw new RuntimeException("Scene not registered: " + name);
        }

        stage.setScene(scene);

        return controllerMap.get(name);
    }
}
