package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

    public static Scene screen01Opening = null;
    public static Scene screen02Menu = null;
    public static Scene screen03Settings = null;
    public static Scene screen04Tutorial = null;
    public static Scene screen05SelectPlayer = null;
    public static Scene screen06Dialogs = null;
    public static Scene screen07Fight = null;
    public static Scene screen08Credits = null;


    public static Scene loadScreen01OpeningScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_01_OPENING_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public static Scene loadScreen02MenuScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_02_MENU_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public static Scene loadScreen03SettingsScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_03_SETTINGS_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public static Scene loadScreen04TutorialScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_04_TUTORIAL_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public static Scene loadScreen05SelectPlayerScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_05_SELECT_PLAYER_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }

    public static Scene loadScreen07FightScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_07_FIGHT_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }
    public static Scene loadScreen08CreditsScene(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(ScreenViewUtils.SCREEN_08_CREDITS_FXML));
        Scene scene = new Scene(root, 1280, 720);

        return scene;
    }
}
