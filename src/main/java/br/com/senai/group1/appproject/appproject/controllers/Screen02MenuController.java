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

public class Screen02MenuController implements Initializable {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonCredits;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonSettings;

    @FXML
    private StackPane container;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.buttonClose.setOnAction((ActionEvent event) -> {
           this.buttonCloseEvent();
        });
        this.buttonSettings.setOnAction((ActionEvent event) -> {
           this.buttonSettingsEvent();
        });
    }

    public void buttonPlayEvent() {}

    public void buttonSettingsEvent() {
        Scene scene = this.buttonSettings.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen03Settings);
    }

    public void buttonCreditsEvent() {}


    public void buttonCloseEvent() {
        System.exit(0);
    }

}
