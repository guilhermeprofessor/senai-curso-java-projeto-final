package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import br.com.senai.group1.appproject.appproject.models.ScreenViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen08CreditsController extends ScreenBaseController {

    public Screen08CreditsController(PreparedSceneModel model) {
        super(model);
    }

    public Screen08CreditsController(Stage stage) {
        super(stage);
    }

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Rectangle backgroundFilterImageView;

    @FXML
    private Button backButton;

    @FXML
    private StackPane container;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.backButton.setOnAction((ActionEvent event) -> {
            this.backButtonEvent();
        });

        this.recalculateBackgroundFilterDimensions();

    }

    public void recalculateBackgroundFilterDimensions() {
        this.backgroundFilterImageView.setX(0);
        this.backgroundFilterImageView.setY(0);
        this.backgroundFilterImageView.setWidth(ScreenViewUtils.getScreenWidth());
        this.backgroundFilterImageView.setHeight(ScreenViewUtils.getScreenHeight());
    }

    public void backButtonEvent() {
        Scene scene = this.backButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen02Menu);
    }

}
