package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.ImageViewUtils;
import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ScreenBaseController implements Initializable {
    private Scene scene;
    private Stage stage;
    private PreparedSceneModel preparedSceneModel;

    @FXML protected ImageView backgroundImageView;

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
        this.stage.setScene(this.scene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public abstract void initialize(URL url, ResourceBundle resourceBundle);

    public void resizeImageViewByScene(ImageView imageView, Scene scene) {
        ImageViewUtils.resizeImageByBind(imageView, scene);
    }

    public void resizeBackgroundImageByBind() {
        ImageViewUtils.resizeImageByBind(this.backgroundImageView, this.getScene());
    }
}
