package br.com.senai.group1.appproject.appproject;

import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import br.com.senai.group1.appproject.appproject.models.ScreenViewUtils;
import com.sun.tools.javac.Main;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        PauseTransition delayToLoadNextScreen = new PauseTransition(Duration.seconds(3));

        delayToLoadNextScreen.setOnFinished((ActionEvent event) -> {
            try {
                SceneHandler.screen02Menu = this.loadScreen02MenuScene(stage);
                stage.setScene(SceneHandler.screen02Menu);
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
}