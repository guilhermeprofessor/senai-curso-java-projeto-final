package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Screen04TutorialController extends ScreenBaseController {
//    @FXML
//    private ImageView backgroundImageView;

    @FXML
    private StackPane container;

    @FXML
    private Button startButton;
    @FXML
    private Button backButton;

    public Screen04TutorialController(PreparedSceneModel model) {
        super(model);
    }

    public Screen04TutorialController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.startButton.setOnAction((ActionEvent event) -> {
            this.startButtonEvent();
        });
        this.backButton.setOnAction((ActionEvent event) -> {
            this.backButtonEvent();
        });

    }

    public void startButtonEvent() {
        Scene scene = this.startButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen05SelectPlayerModel.getScene());
    }

    public void backButtonEvent() {
        Scene scene = this.startButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen02MenuModel.getScene());
    }

}
