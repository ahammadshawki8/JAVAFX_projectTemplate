package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import util.GlobalState;

public class FlowPaneController extends BaseController {

    // KEY EVENT HANDLER LOGIC
    String CURRENT_FILE_NAME = GlobalState.FLOW_PANE_FILE; // UPDATE THIS
    private EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            System.out.println("Key pressed: " + keyEvent.getCode());

            // ADD YOUR KEY PRESS LOGIC HERE
            if (keyEvent.getCode().toString().equals("W")) {
                System.out.println("W key pressed!");
            }
        }
    };

    public void initializeKeyHandling() {
        sceneController.addKeyEventHandler(CURRENT_FILE_NAME, keyEventHandler);
    }

    @Override
    public void setSceneController(SceneController controller) {
        super.setSceneController(controller);
        initializeKeyHandling();
    }
    // --------------------------------------------------------------------------------------------
}
