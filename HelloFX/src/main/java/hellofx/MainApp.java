package hellofx;

import controller.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.GlobalState;
import java.net.URL;

// IMPORT ALL CONTROLLERS HERE
import controller.EventHandlingController;
import controller.CssStylingController;
import controller.Scene1Controller;
import controller.Scene2Controller;
import controller.LoginController;
import controller.UserProfileController;
import controller.ImageViewController;
import controller.CheckBoxController;
import controller.RadioButtonController;
import controller.HelloWorldController;
import controller.DatePickerController;
import controller.ListViewController;
import controller.FlowPaneController;



public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // CONTROLLER INITIALIZATION METHOD - DO NOT MODIFY
    private <T> void initController(String resourceFile, Class<T> controllerClass, SceneController sceneController) {
        try {
            URL location = getClass().getResource("/fxml/" + resourceFile + ".fxml");
            if (location == null) {
                throw new RuntimeException("FXML not found: " + resourceFile);
            }

            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();

            Object controller = loader.getController();
            if (controllerClass.isInstance(controller)) {
                controllerClass
                        .getMethod("setSceneController", SceneController.class)
                        .invoke(controller, sceneController);
            } else {
                throw new RuntimeException("Controller type mismatch for: " + resourceFile);
            }

            sceneController.addScene(resourceFile, root, controller);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing controller for " + resourceFile, e);
        }
    }



    @Override
    public void start(Stage stage) throws Exception {
        SceneController sceneController = new SceneController(stage);

        // REGISTER CONTROLLERS
        initController(GlobalState.EVENT_HANDLING_FILE, EventHandlingController.class, sceneController);
        initController(GlobalState.CSS_STYLING_FILE, CssStylingController.class, sceneController);
        initController(GlobalState.SCENE_1_FILE, Scene1Controller.class, sceneController);
        initController(GlobalState.SCENE_2_FILE, Scene2Controller.class, sceneController);
        initController(GlobalState.LOGIN_FILE, LoginController.class, sceneController);
        initController(GlobalState.USER_PROFILE_FILE, UserProfileController.class, sceneController);
        initController(GlobalState.IMAGE_VIEW_FILE, ImageViewController.class, sceneController);
        initController(GlobalState.CHECK_BOX_FILE, CheckBoxController.class, sceneController);
        initController(GlobalState.RADIO_BUTTON_FILE, RadioButtonController.class, sceneController);
        initController(GlobalState.HELLO_WORLD_FILE, HelloWorldController.class, sceneController);
        initController(GlobalState.DATE_PICKER_FILE, DatePickerController.class, sceneController);
        initController(GlobalState.LIST_VIEW_FILE, ListViewController.class, sceneController);
        initController(GlobalState.FLOW_PANE_FILE, FlowPaneController.class, sceneController);






        // CHOOSE THE INITIAL SCENE
        sceneController.switchTo(GlobalState.FLOW_PANE_FILE);

        // SETUP THE STAGE
        URL iconURL = getClass().getResource("/images/brand.png");
        if (iconURL != null) {
            stage.getIcons().add(new Image(iconURL.toExternalForm()));
        }

        stage.setTitle("Hello World");
        stage.show();
    }
}
