package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import de.jensd.fx.glyphs.testapps.App;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen09EndGameController extends ScreenBaseController {

    @FXML
    private StackPane container;

    @FXML
    private Button playAgainButton;

    public long elapsedTime = 0;
    public Image winImage = null;
    public Image lostImage = null;

    public Screen09EndGameController(PreparedSceneModel preparedSceneModel) {
        super(preparedSceneModel);
    }

    public Screen09EndGameController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadPlayerWinImage();
        this.loadPlayerLostImage();
        this.loadBackgroundImageByGameState();


        this.playAgainButton.setOnAction((ActionEvent event) -> {
           this.playAgainButtonEvent();
        });
    }

    public void loadPlayerWinImage() {
        this.winImage = ImageUtils.loadInputStream(ImageUtils.SCENE_09_PLAYER_WIN_BACKGROUND);
    }
    public void loadPlayerLostImage() {
        this.lostImage = ImageUtils.loadInputStream(ImageUtils.SCENE_09_PLAYER_LOST_BACKGROUND);
    }


    public void loadBackgroundImageByGameState() {
        AnimationTimer animationTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTime > now) return;

                elapsedTime = now + 100_000_000L;

                if(AppSettings.getIsPlayerWin() != GameStateEnum.PLAYER_WIN && AppSettings.getIsPlayerWin() != GameStateEnum.PLAYER_LOST) return;

                String imageUri = "";
                if(AppSettings.getIsPlayerWin() == GameStateEnum.PLAYER_WIN) {
                    backgroundImageView.setImage(winImage);
                } else if(AppSettings.getIsPlayerWin() == GameStateEnum.PLAYER_LOST) {
                    backgroundImageView.setImage(lostImage);
                }

                this.stop();
            }
        };

        animationTime.start();
    }



    public void playAgainButtonEvent() {
        this.goToMenuScene();
    }

    public void goToMenuScene() {
        SceneHandler.loadAllScene();
        SceneHandler.goToScene02MainMenu(true);


    }

}