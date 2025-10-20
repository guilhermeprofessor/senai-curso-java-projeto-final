package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.controllers.ScreenBaseController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppSceneModel {

    private Stage stage;
    private Scene scene;
    private ScreenBaseController controller;

    public AppSceneModel(Stage stage, Scene scene,ScreenBaseController controller) {
        this.scene = scene;
        this.stage = stage;
        this.controller = controller;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ScreenBaseController getController() {
        return controller;
    }

    public void setController(ScreenBaseController controller) {
        this.controller = controller;
    }
}
