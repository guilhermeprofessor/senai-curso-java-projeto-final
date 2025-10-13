package br.com.senai.group1.appproject.appproject.controllers;

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


public class Screen04TutorialController implements Initializable {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private StackPane container;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.startButton.setOnAction((ActionEvent event) -> {
            this.startButtonEvent();
        });

    }

    public void startButtonEvent() {
        Scene scene = this.startButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen05SelectPlayer);
    }

}
