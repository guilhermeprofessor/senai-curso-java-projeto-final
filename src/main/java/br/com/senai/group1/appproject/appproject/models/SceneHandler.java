package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import br.com.senai.group1.appproject.appproject.controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    public static Scene getSceneByElement(Node node) throws Exception {
        Scene scene = node.getScene();

        if(scene == null) {
            System.err.println("This element is not in the scene");
        }

        return scene;
    }

    public static Stage getStageByElement(Node node) throws Exception {
        Scene scene = node.getScene();

        if(scene == null) {
            throw new Exception("This element is not in the scene");
        }

        Stage stage = (Stage) scene.getWindow();


        if(stage == null) {
            throw new Exception("The stage is null");
        }

        return stage;
    }

    public static FXMLLoader getFxmlLoader(String viewPath)  throws IOException {
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

        return model;
    }

    public static Scene loadScreen01OpeningScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_01_OPENING_FXML, new Screen01OpeningController(stage));


        return preparedSceneModel.getScene();
    }

    public static Scene loadScreen02MenuScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_02_MENU_FXML, new Screen02MenuController(stage));


        return preparedSceneModel.getScene();
    }

    public static Scene loadScreen03SettingsScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_03_SETTINGS_FXML, new Screen03SettingsController(stage));


        return preparedSceneModel.getScene();
    }

    public static Scene loadScreen04TutorialScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_04_TUTORIAL_FXML,new Screen04TutorialController(stage));

        return preparedSceneModel.getScene();
    }

    public static Scene loadScreen05SelectPlayerScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_05_SELECT_PLAYER_FXML, new Screen05SelectPlayerController(stage));


        return preparedSceneModel.getScene();
    }

    public static Scene loadScreen07FightScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_07_FIGHT_FXML,new Screen07FightController(stage));


        return preparedSceneModel.getScene();
    }
    public static Scene loadScreen08CreditsScene(Stage stage) throws IOException {
        PreparedSceneModel preparedSceneModel = SceneHandler.buildPreparedScene(stage,
                ScreenViewUtils.SCREEN_08_CREDITS_FXML,new Screen08CreditsController(stage));


        return preparedSceneModel.getScene();
    }
}
