package br.com.senai.group1.appproject.appproject;

import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import br.com.senai.group1.appproject.appproject.models.ScreenViewUtils;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_01_OPENING_FXML));
//        String classe = getClass();
        Scene scene = SceneHandler.loadScreen01OpeningScene(stage);
        stage.setScene(scene);

        SceneHandler.screen01Opening = scene;
        SceneHandler.screen02Menu = SceneHandler.loadScreen02MenuScene(stage);
        SceneHandler.screen03Settings = SceneHandler.loadScreen03SettingsScene(stage);
        SceneHandler.screen04Tutorial = SceneHandler.loadScreen04TutorialScene(stage);
        SceneHandler.screen05SelectPlayer = SceneHandler.loadScreen05SelectPlayerScene(stage);
        SceneHandler.screen07Fight = SceneHandler.loadScreen07FightScene(stage);
        SceneHandler.screen08Credits = SceneHandler.loadScreen08CreditsScene(stage);


        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        PauseTransition delayToLoadNextScreen = new PauseTransition(Duration.seconds(3));

        delayToLoadNextScreen.setOnFinished((ActionEvent event) -> {
            try {
                stage.setScene(SceneHandler.screen02Menu);
//                stage.setScene(SceneHandler.screen05SelectPlayer);
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