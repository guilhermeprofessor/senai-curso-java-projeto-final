package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen10ThanksgivingController extends ScreenBaseController {

    @FXML
    private StackPane container;

    public long elapsedTime = 0;
    public boolean canItStopApp = false;

    public Screen10ThanksgivingController(PreparedSceneModel preparedSceneModel) {
        super(preparedSceneModel);
    }

    public Screen10ThanksgivingController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.waitToCloseAppAnimationTimer();

    }

    public void waitToCloseAppAnimationTimer() {

        AnimationTimer animationTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTime > now) return;

                elapsedTime = now + 1_000_000_000L;

                if(canItStopApp == false) return;

                closeAppAnimationTimer();
                this.stop();
            }
        };

        animationTime.start();
    }
    public void closeAppAnimationTimer() {

        AnimationTimer animationTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTime + 3_000_000_000L > now) return;

                this.stop();
                System.exit(0);
            }
        };

        animationTime.start();
    }


    public boolean isCanItStopApp() {
        return canItStopApp;
    }

    public void setCanItStopApp(boolean canItStopApp) {
        this.canItStopApp = canItStopApp;
    }
}