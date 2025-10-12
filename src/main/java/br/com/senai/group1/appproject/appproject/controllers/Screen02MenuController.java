package br.com.senai.group1.appproject.appproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
    }

    public void buttonPlayEvent() {}
    public void buttonSettingsEvent() {}
    public void buttonCreditsEvent() {}
    public void buttonCloseEvent() {
        System.exit(0);
    }

}
