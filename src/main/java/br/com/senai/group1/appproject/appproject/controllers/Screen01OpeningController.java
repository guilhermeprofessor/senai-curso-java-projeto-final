package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Screen01OpeningController extends ScreenBaseController {
//    @FXML
//    private ImageView backgroundImageView;

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
        SceneHandler.loadAllSceneExceptTheOpeningScene();
        AudioUtils.changeMediaWithDecay(AppSettings.getBackgroundMediaPlayer(),0.001, 10_000_000);
        AppSettings.setBackgroundMediaPlayer(AudioUtils.getMediaPlayerByPath(AudioUtils.OPENING_SOUND, AppSettings.getMusicVolume()));
        AppSettings.getBackgroundMediaPlayer().play();
        AppSettings.getBackgroundMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
    }


}
