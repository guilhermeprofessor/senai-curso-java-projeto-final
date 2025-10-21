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

        SceneHandler.setStage(stage);
        SceneHandler.screen01OpeningModel = SceneHandler.loadScreen01OpeningScene(stage);


        stage.setScene(SceneHandler.screen01OpeningModel.getScene());
        stage.initStyle(StageStyle.TRANSPARENT);


        Rectangle2D screenCenterValues = ScreenViewUtils.getThePositionToCenterTheScreen();
        stage.setX(screenCenterValues.getWidth());
        stage.setY(screenCenterValues.getHeight());

        stage.show();



        PauseTransition delayToLoadNextScreen = new PauseTransition(Duration.seconds(1));
        delayToLoadNextScreen.setOnFinished((ActionEvent event) -> {
            try {
//                stage.setScene(SceneHandler.screen02Menu);
                SceneHandler.goToScene02MainMenu(false);
//                stage.setScene(SceneHandler.screen07Fight);
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