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
        Scene scene = this.loadScreen01OpeningScene(stage);
        stage.setScene(scene);

        SceneHandler.screen01Opening = scene;
        SceneHandler.screen02Menu = this.loadScreen02MenuScene(stage);
        SceneHandler.screen03Settings = this.loadScreen03SettingsScene(stage);
        SceneHandler.screen04Tutorial = this.loadScreen04TutorialScene(stage);
        SceneHandler.screen05SelectPlayer = this.loadScreen05SelectPlayerScene(stage);
        SceneHandler.screen07Fight = this.loadScreen07FightScene(stage);
        SceneHandler.screen08Credits = this.loadScreen08CreditsScene(stage);


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

    public Scene loadScreen01OpeningScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_01_OPENING_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public Scene loadScreen02MenuScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_02_MENU_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public Scene loadScreen03SettingsScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_03_SETTINGS_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public Scene loadScreen04TutorialScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_04_TUTORIAL_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public Scene loadScreen05SelectPlayerScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_05_SELECT_PLAYER_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public Scene loadScreen07FightScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_07_FIGHT_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }
    public Scene loadScreen08CreditsScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ScreenViewUtils.SCREEN_08_CREDITS_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }
}