package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import br.com.senai.group1.appproject.appproject.controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

//    public static Scene screen01Opening = null;
//    public static Scene screen02Menu = null;
//    public static Scene screen03Settings = null;
//    public static Scene screen04Tutorial = null;
//    public static Scene screen05SelectPlayer = null;
//    public static Scene screen06Dialogs = null;
//    public static Scene screen07Fight = null;
//    public static Scene screen08Credits = null;
//    public static Scene screen09EndGame = null;

    public static AppSceneModel screen01OpeningModel = null;
    public static AppSceneModel screen02MenuModel = null;
    public static AppSceneModel screen03SettingsModel = null;
    public static AppSceneModel screen04TutorialModel = null;
    public static AppSceneModel screen05SelectPlayerModel = null;
    public static AppSceneModel screen06DialogsModel = null;
    public static AppSceneModel screen07FightModel = null;
    public static AppSceneModel screen08CreditsModel = null;
    public static AppSceneModel screen09EndGameModel = null;
    public static AppSceneModel screen10ThanksgivingModel = null;


    private static Stage currentStage = null;

    public static void setStage(Stage stage) {
        if (stage == null) return;

        SceneHandler.currentStage = (stage);
    }

    public static Stage getCurrentStage() {
        return SceneHandler.currentStage;
    }

    public static Scene getCurrentScene() {
        if (SceneHandler.currentStage == null) return null;

        return SceneHandler.getCurrentStage().getScene();
    }


    public static Scene getSceneByElement(Node node) throws Exception {
        Scene scene = node.getScene();

        if (scene == null) {
            System.err.println("This element is not in the scene");
        }

        return scene;
    }

    public static Stage getStageByElement(Node node) throws Exception {
        Scene scene = node.getScene();

        if (scene == null) {
            throw new Exception("This element is not in the scene");
        }

        Stage stage = (Stage) scene.getWindow();


        if (stage == null) {
            throw new Exception("The stage is null");
        }

        return stage;
    }

    public static FXMLLoader getFxmlLoader(String viewPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(viewPath));

        return fxmlLoader;
    }

    public static ScreenBaseController getPreparedController(FXMLLoader fxmlLoader, Stage stage, Scene scene) {
        ScreenBaseController controller = fxmlLoader.getController();

        controller.setScene(scene);
        controller.setStage(stage);

        return controller;
    }

    public static PreparedSceneModel buildPreparedScene(Stage stage, String viewPath,
                                                        ScreenBaseController controller) throws IOException {
        PreparedSceneModel model = new PreparedSceneModel(stage, viewPath, controller);

        SceneHandler.setStage(stage);

        return model;
    }

    public static AppSceneModel loadScreen01OpeningScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen01OpeningController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_01_OPENING_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen02MenuScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen02MenuController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_02_MENU_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen03SettingsScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen03SettingsController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_03_SETTINGS_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen04TutorialScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen04TutorialController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_04_TUTORIAL_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen05SelectPlayerScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen05SelectPlayerController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_05_SELECT_PLAYER_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen07FightScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen07FightController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_07_FIGHT_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen08CreditsScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen08CreditsController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_08_CREDITS_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel loadScreen09EngGameScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen09EndGameController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_09_END_GAME_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }

    public static AppSceneModel load10ThanksgivingScene(Stage stage) throws IOException {
        ScreenBaseController controller = new Screen10ThanksgivingController(stage);

        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_10_THANKSGIVING_FXML, controller);

        AppSceneModel model = new AppSceneModel(stage, preparedSceneModel.getScene(), controller);

        return model;
    }


    public static void loadAllSceneExceptTheOpeningScene() {
        try {
            AppSettings.setIsPlayerWin(GameStateEnum.UNDEFINED);

            SceneHandler.screen02MenuModel = SceneHandler.loadScreen02MenuScene(SceneHandler.getCurrentStage());
            SceneHandler.screen03SettingsModel = SceneHandler.loadScreen03SettingsScene(SceneHandler.getCurrentStage());
            SceneHandler.screen04TutorialModel = SceneHandler.loadScreen04TutorialScene(SceneHandler.getCurrentStage());
            SceneHandler.screen05SelectPlayerModel = SceneHandler.loadScreen05SelectPlayerScene(SceneHandler.getCurrentStage());
            SceneHandler.screen07FightModel = SceneHandler.loadScreen07FightScene(SceneHandler.getCurrentStage());
            SceneHandler.screen08CreditsModel = SceneHandler.loadScreen08CreditsScene(SceneHandler.getCurrentStage());
            SceneHandler.screen09EndGameModel = SceneHandler.loadScreen09EngGameScene(SceneHandler.getCurrentStage());
            SceneHandler.screen10ThanksgivingModel = SceneHandler.load10ThanksgivingScene(SceneHandler.getCurrentStage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadAllScene() {
        try {
            AppSettings.setIsPlayerWin(GameStateEnum.UNDEFINED);

            SceneHandler.screen01OpeningModel = SceneHandler.loadScreen01OpeningScene(SceneHandler.getCurrentStage());
            SceneHandler.screen02MenuModel = SceneHandler.loadScreen02MenuScene(SceneHandler.getCurrentStage());
            SceneHandler.screen03SettingsModel = SceneHandler.loadScreen03SettingsScene(SceneHandler.getCurrentStage());
            SceneHandler.screen04TutorialModel = SceneHandler.loadScreen04TutorialScene(SceneHandler.getCurrentStage());
            SceneHandler.screen05SelectPlayerModel = SceneHandler.loadScreen05SelectPlayerScene(SceneHandler.getCurrentStage());
            SceneHandler.screen07FightModel = SceneHandler.loadScreen07FightScene(SceneHandler.getCurrentStage());
            SceneHandler.screen08CreditsModel = SceneHandler.loadScreen08CreditsScene(SceneHandler.getCurrentStage());
            SceneHandler.screen09EndGameModel = SceneHandler.loadScreen09EngGameScene(SceneHandler.getCurrentStage());
            SceneHandler.screen10ThanksgivingModel = SceneHandler.load10ThanksgivingScene(SceneHandler.getCurrentStage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadAllSceneAndGoToOpeningScene() {
        SceneHandler.loadAllScene();
        SceneHandler.goToScene01Opening();
    }

    public static void goToScene(Scene scene) {
        SceneHandler.getCurrentStage().setScene(scene);
    }

    public static void goToScene01Opening() {
        SceneHandler.goToScene(SceneHandler.screen01OpeningModel.getScene());
        AudioUtils.changeMediaWithDecay(AppSettings.getBackgroundMediaPlayer(), 0.001, 10_000_000);
        AppSettings.setBackgroundMediaPlayer(AudioUtils.getMediaPlayerByPath(AudioUtils.OPENING_SOUND, AppSettings.getMusicVolume()));
        AppSettings.getBackgroundMediaPlayer().play();
        AppSettings.getBackgroundMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static void goToScene02MainMenu(boolean playMusicAgain) {
        SceneHandler.goToScene(SceneHandler.screen02MenuModel.getScene());
        if (playMusicAgain) {

            AudioUtils.changeMediaWithDecay(AppSettings.getBackgroundMediaPlayer(), 0.001, 10_000_000);
            AppSettings.setBackgroundMediaPlayer(AudioUtils.getMediaPlayerByPath(AudioUtils.OPENING_SOUND, AppSettings.getMusicVolume()));
            AppSettings.getBackgroundMediaPlayer().play();
            AppSettings.getBackgroundMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        }
    }

    public static void goToScene07Fight() {
        SceneHandler.goToScene(SceneHandler.screen07FightModel.getScene());
        MediaPlayer mediaPlayer = AudioUtils.getMediaPlayerByPath(AudioUtils.BATTLE_SOUND, AppSettings.getMusicVolume());
        MediaPlayer oldSound = AppSettings.getBackgroundMediaPlayer();
        AudioUtils.changeMediaWithDecay(oldSound, 0.001, 10_000_000);
        AppSettings.setBackgroundMediaPlayer(mediaPlayer);
        AppSettings.getBackgroundMediaPlayer().play();
        AppSettings.getBackgroundMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
    }

}
