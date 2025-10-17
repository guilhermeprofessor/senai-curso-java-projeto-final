package br.com.senai.group1.appproject.appproject;

import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import br.com.senai.group1.appproject.appproject.models.ScreenViewUtils;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenViewUtils.setScreenWidth(1280);
        ScreenViewUtils.setScreenHeight(720);

        SceneHandler.screen01Opening = SceneHandler.loadScreen01OpeningScene(stage);
        SceneHandler.screen02Menu = SceneHandler.loadScreen02MenuScene(stage);
        SceneHandler.screen03Settings = SceneHandler.loadScreen03SettingsScene(stage);
        SceneHandler.screen04Tutorial = SceneHandler.loadScreen04TutorialScene(stage);
        SceneHandler.screen05SelectPlayer = SceneHandler.loadScreen05SelectPlayerScene(stage);
        SceneHandler.screen07Fight = SceneHandler.loadScreen07FightScene(stage);
        SceneHandler.screen08Credits = SceneHandler.loadScreen08CreditsScene(stage);


        stage.setScene(SceneHandler.screen01Opening);

        Rectangle2D screenCenterValues = ScreenViewUtils.getThePositionToCenterTheScreen();
        stage.setX(screenCenterValues.getWidth());
        stage.setY(screenCenterValues.getHeight());



        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        PauseTransition delayToLoadNextScreen = new PauseTransition(Duration.seconds(1));

        delayToLoadNextScreen.setOnFinished((ActionEvent event) -> {
            try {
//                stage.setScene(SceneHandler.screen02Menu);
                stage.setScene(SceneHandler.screen07Fight);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        delayToLoadNextScreen.play();




    }

    public static void main(String[] args) {
        launch();
    }

}