package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ScreenBaseController implements Initializable {
    private Scene scene;
    private Stage stage;
    private PreparedSceneModel preparedSceneModel;

    public ScreenBaseController(PreparedSceneModel model) {
        this(model.getStage());
        this.preparedSceneModel = model;
    }


    public ScreenBaseController(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        if(this.scene == null) {
            Stage stage = this.getStage();
            this.scene = stage.getScene();
        }

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

    @Override
    public abstract void initialize(URL url, ResourceBundle resourceBundle);
}
