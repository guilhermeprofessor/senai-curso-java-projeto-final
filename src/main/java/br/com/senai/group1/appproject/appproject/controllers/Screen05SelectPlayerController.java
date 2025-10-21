package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Screen05SelectPlayerController extends ScreenBaseController {

    @FXML
    private Button backButton;

//    @FXML
//    private ImageView backgroundImageView;

    @FXML
    private StackPane container;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button nextButton;

    @FXML
    private ImageView playerImageView;

    @FXML
    private Button previousButton;

    @FXML
    private Button startButton;

    private CharacterModel selectPlayer;
    private List<CharacterModel> playerList;
    private int playerIndex = 0;

    public Screen05SelectPlayerController(PreparedSceneModel model) {
        super(model);
    }

    public Screen05SelectPlayerController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.populatePlayerList();


        this.backButton.setOnAction((ActionEvent event) -> {
           this.backButtonEvent();
        });

        this.startButton.setOnAction((ActionEvent event) -> {
           this.startButtonEvent();
        });

        this.nextButton.setOnAction((ActionEvent event) -> {
           this.nextButtonEvent();
        });

        this.previousButton.setOnAction((ActionEvent event) -> {
           this.previousButtonEvent();
        });

    }

    private void populatePlayerList() {
        this.playerList = new ArrayList<>();
        CharacterModel player01 = new PlayerCharacterModel("player 01", "",1500);

        this.playerList.add(player01);
    }

    public void backButtonEvent() {
        Scene scene = this.backButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(SceneHandler.screen04TutorialModel.getScene());
    }

    public void startButtonEvent() {
        String name = this.nameTextField.getText();
        AppSettings.setPlayerName(name);

        Scene scene = this.backButton.getScene();
        Stage stage = (Stage) scene.getWindow();

        Screen07FightController controller =
                ((Screen07FightController)SceneHandler.screen07FightModel.getController());
        controller.playerModel.setName(AppSettings.getPlayerName());
        controller.getPlayerNameLabel().setText(AppSettings.getPlayerName());
        controller.getSystemNameLabel().setText("Valentão");
        SceneHandler.goToScene07Fight();
    }

    public void nextButtonEvent() {
        this.playerIndex++;

        if(this.playerIndex == this.playerList.size()) {
            this.playerIndex = 0;
        }

        this.updatePlayerDisplay();
    }
    public void previousButtonEvent() {
        this.playerIndex++;

        if(this.playerIndex == this.playerList.size()) {
            this.playerIndex = 0;
        }

        this.updatePlayerDisplay();
    }

    public void updatePlayerDisplay() {
        this.selectPlayer = this.playerList.get(this.playerIndex);

//        Image image = new Image(this.selectPlayer.getImageUri());
//        this.playerImageView.setImage(image);

        this.nameTextField.setText(this.selectPlayer.getName());
    }


}
