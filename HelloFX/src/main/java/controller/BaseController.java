package controller;

public abstract class BaseController {
    protected SceneController sceneController;

    public void setSceneController(SceneController controller) {
        this.sceneController = controller;
    }
}