package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.AppSettings;
import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import br.com.senai.group1.appproject.appproject.models.ResolutionModel;
import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class Screen03SettingsController extends ScreenBaseController {

//    @FXML
//    private ImageView backgroundImageView;

    @FXML
    private Button backButton;

    @FXML
    private StackPane container;

    @FXML
    private SplitMenuButton resolutionMenuButton;

    @FXML
    private Slider soundEffectsSlider;

    @FXML
    private Slider volumeSlider;

    public Screen03SettingsController(PreparedSceneModel model) {
        super(model);
    }

    public Screen03SettingsController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        

        this.populateResolutionMenu();
        this.configureVolumeSlider();
        this.configureSoundEffectsSlider();
        this.backButton.setOnAction((ActionEvent event) -> {
            this.backButtonEvent();
        });

        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle = screen.getBounds();

    }

    public void populateResolutionMenu() {
        ResolutionModel[] resolutionList = {
            new ResolutionModel("1920 x 1080 (Full HD)",1920,1080),
            new ResolutionModel("1600 x 900",1600,900),
            new ResolutionModel("1366 x 768",1366,768),
            new ResolutionModel("1280 x 720 (HD)",1280,720),
        };

        for (ResolutionModel resolution : resolutionList) {
            this.resolutionMenuButton.getItems().add(this.buildMenuItem(resolution));
        }
    }

    public MenuItem buildMenuItem(ResolutionModel resolution) {
        MenuItem item = new MenuItem(resolution.getName());
        item.setOnAction((ActionEvent event) -> {
            Screen screen = Screen.getPrimary();
            Rectangle2D screenBounds = screen.getBounds();
            this.resolutionMenuButton.setText(resolution.getName());

            Scene currentScene = this.resolutionMenuButton.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            double positionX = screenBounds.getWidth() - resolution.getWidth();
            positionX /= 2;

            double positionY = screenBounds.getHeight() - resolution.getHeight();
            positionY /= 2;


            currentStage.setX(positionX);
            currentStage.setY(positionY);

            currentStage.setWidth(resolution.getWidth());
            currentStage.setHeight(resolution.getHeight());
        });

        return item;
    }


    public void backButtonEvent() {
        Scene scene = this.backButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen02MenuModel.getScene());
    }

    public void configureVolumeSlider() {
        this.volumeSlider.setMin(0);
        this.volumeSlider.setMax(100);

        this.volumeSlider.setValue(AppSettings.getMusicVolume() * 100);

        this.volumeSlider.setShowTickLabels(true);
        this.volumeSlider.setShowTickMarks(true);

        this.volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                double value = newValue.doubleValue() / 100;

                AppSettings.setMusicVolume(value);
                if(AppSettings.getBackgroundMediaPlayer() == null) return;
                AppSettings.getBackgroundMediaPlayer().setVolume(AppSettings.getMusicVolume());
            }
        });
    }

    public void configureSoundEffectsSlider() {
        this.soundEffectsSlider.setMin(0);
        this.soundEffectsSlider.setMax(100);

        this.soundEffectsSlider.setValue(AppSettings.getEffectVolume() * 100);

        this.soundEffectsSlider.setShowTickLabels(true);
        this.soundEffectsSlider.setShowTickMarks(true);

        this.soundEffectsSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                double value = newValue.doubleValue() / 100;
                AppSettings.setEffectVolume(value);
                if(AppSettings.getForegroundMediaPlayer() == null) return;
                AppSettings.getForegroundMediaPlayer().setVolume(AppSettings.getEffectVolume());
            }
        });
    }


}
