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

public class Screen02MenuController extends ScreenBaseController {

//    @FXML
//    private ImageView backgroundImageView;

    @FXML
    private Button closeButton;

    @FXML
    private Button creditsButton;

    @FXML
    private Button playButton;

    @FXML
    private Button settingsButton;

    @FXML
    private StackPane container;

    public Screen02MenuController(PreparedSceneModel model) {
        super(model);
    }

    public Screen02MenuController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.closeButton.setOnAction((ActionEvent event) -> {
           this.closeButtonEvent();
        });

        this.creditsButton.setOnAction((ActionEvent event) -> {
           this.creditsButtonEvent();
        });

        this.playButton.setOnAction((ActionEvent event) -> {
           this.playButtonEvent();
        });

        this.settingsButton.setOnAction((ActionEvent event) -> {
           this.settingsButtonEvent();
        });
    }

    public void playButtonEvent() {
        Scene scene = this.playButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen04TutorialModel.getScene());
    }

    public void settingsButtonEvent() {
        Scene scene = this.settingsButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen03SettingsModel.getScene());
    }

    public void creditsButtonEvent() {
        Scene scene = this.creditsButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen08CreditsModel.getScene());
    }


    public void closeButtonEvent() {
        Screen10ThanksgivingController controller =
                (Screen10ThanksgivingController)  SceneHandler.screen10ThanksgivingModel.getController();

        controller.setCanItStopApp(true);
        SceneHandler.getCurrentStage().setScene(SceneHandler.screen10ThanksgivingModel.getScene());
    }

}
