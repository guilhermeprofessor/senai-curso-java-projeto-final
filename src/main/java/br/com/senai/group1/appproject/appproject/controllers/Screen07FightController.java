package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Screen07FightController extends ScreenBaseController {

    @FXML
    private Button actionAttackButton;

    @FXML
    private Button actionDefenseButton;

    @FXML
    private Button actionDodgeButton;

    @FXML
    private Button actionEnergyButton;

    @FXML
    private Button actionSpecialPowerButton;


    @FXML
    private StackPane container;

    @FXML
    private AnchorPane scenePane;


    @FXML
    private AnchorPane hudPlayerAnchorPane;

    @FXML
    private AnchorPane hudSystemAnchorPane;

    @FXML
    private GridPane playerGridPane;

    @FXML
    private Rectangle playerHPBackgroundRect;

    @FXML
    private Rectangle playerHPForegroundRect;

    @FXML
    private ImageView playerHUDImageView;

    @FXML
    private ImageView playerImageView;

    @FXML
    private Rectangle playerSPBackgroundRect;

    @FXML
    private Rectangle playerSPForegroundRect;

    @FXML
    private Label playerStatusText;


    @FXML
    private Rectangle systemHPBackgroundRect;

    @FXML
    private Rectangle systemHPForegroundRect;

    @FXML
    private ImageView systemHUDImageView;

    @FXML
    private ImageView systemImageView;

    @FXML
    private Rectangle systemSPBackgroundRect;

    @FXML
    private Rectangle systemSPForegroundRect;

    @FXML
    private Label systemStatusText;


    List<Button> actionButtonList = new ArrayList<>();
    List<GridPane> gridPaneList = new ArrayList<>();
    int[] gridPanelOrderList = null;

    public CharacterModel playerModel;
    public CharacterModel systemModel;

    public Screen07FightController(PreparedSceneModel model) {
        super(model);
    }

    public Screen07FightController(Stage stage) {
        super(stage);
    }

    public long elapsedTime = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.clearStatusLabelText();

        this.fillPlayerCharacterModel();
        this.fillSystemCharacterModel();

        this.populateActionButtonList();

        ActionButtonUtils.setActionToAttackButton(this.actionAttackButton, 3500, this.scenePane, this.playerModel, this.systemModel);

        ActionButtonUtils.setActionToDefenseButton(this.actionDefenseButton, 3500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToEnergyButton(this.actionEnergyButton, 2500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToDodgeButton(this.actionDodgeButton, 1500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToSpecialPowerButton(this.actionSpecialPowerButton, 10000, this.scenePane, this.playerModel, this.systemModel);

        this.playerModel.loadImageFromSpriteList();
        this.systemModel.loadImageFromSpriteList();


        this.playerModel.playSpriteAnimation();
        this.systemModel.playSpriteAnimation();

    }

    private void fillPlayerCharacterModel() {
        this.playerModel = new PlayerCharacterModel("Player 01", "/images/animations/player_idle_01.png");
        this.playerModel.setCharacterImaveView(this.playerImageView);
        this.playerModel.setStatusLabel(this.playerStatusText);

        this.playerModel.loadImageFromSpriteList();

    }
    private void fillSystemCharacterModel() {
        this.systemModel = new SystemCharacterModel("System", "/images/animations/system_idle_01.png");
        this.systemModel.setCharacterImaveView(this.systemImageView);
        this.systemModel.setStatusLabel(this.systemStatusText);

        this.systemModel.loadImageFromSpriteList();
    }

    private void clearStatusLabelText() {
        this.playerStatusText.setText("");
        this.systemStatusText.setText("");
    }

    public void populateActionButtonList() {
        ActionButtonUtils.getCurrentActionButtonList().add(this.actionAttackButton);
        ActionButtonUtils.getCurrentActionButtonList().add(this.actionDefenseButton);
        ActionButtonUtils.getCurrentActionButtonList().add(this.actionEnergyButton);
        ActionButtonUtils.getCurrentActionButtonList().add(this.actionDodgeButton);
        ActionButtonUtils.getCurrentActionButtonList().add(this.actionSpecialPowerButton);
    }

    public void animationHudDisplays() {
        long animationDelay = (long) ((float)(.1 ) * 1_000_000_000l);
        double elapsedTime1 = 0L;

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTime1 > now) return;


            }
        };

        animationTimer.start();

    }





}
