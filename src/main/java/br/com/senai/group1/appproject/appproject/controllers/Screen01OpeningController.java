package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen01OpeningController extends ScreenBaseController {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private StackPane container;

    @FXML
    private Label courseTitleLabel;

    @FXML
    private ImageView logoImageView;

    public Screen01OpeningController(PreparedSceneModel preparedSceneModel) {
        super(preparedSceneModel);
    }

    public Screen01OpeningController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Stage stage = this.getStage();


            System.out.println(this.getScene().getWidth());
            System.out.println(this.getScene().getHeight());
            System.out.println(this.backgroundImageView.getFitWidth());
            System.out.println(this.backgroundImageView.getFitHeight());

            this.backgroundImageView.setFitWidth(stage.getWidth());
            this.backgroundImageView.setFitHeight(stage.getHeight());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
