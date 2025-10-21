package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
    private Button exitAppButton;


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
    private Label playerNameLabel;

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
    private Label systemNameLabel;

    @FXML
    private Rectangle systemSPBackgroundRect;

    @FXML
    private Rectangle systemSPForegroundRect;

    @FXML
    private Label systemStatusText;


    List<Button> actionButtonList = new ArrayList<>();
    List<GridPane> gridPaneList = new ArrayList<>();
    int[] gridPanelOrderList = null;
    long hudElapsedTime = 0;
    long mainLoopElpasedTime = 0;
    AnimationTimer mainLoopAnimationTimer = null;

    public CharacterModel playerModel;
    public SystemCharacterModel systemModel;

    public GameStateEnum isPlayerWinState = GameStateEnum.UNDEFINED;

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

        this.exitAppButton.setOnAction((ActionEvent event) -> {
            this.exitAppButtonEvent();
        });


        this.fillPlayerCharacterModel();
        this.fillSystemCharacterModel();

        this.populateActionButtonList();

        ActionButtonUtils.setActionToAttackButton(this.actionAttackButton, 3500, this.scenePane, this.playerModel, this.systemModel);

        ActionButtonUtils.setActionToDefenseButton(this.actionDefenseButton, 3500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToEnergyButton(this.actionEnergyButton, 2500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToDodgeButton(this.actionDodgeButton, 1500, this.scenePane, this.playerModel, this.systemModel);
        ActionButtonUtils.setActionToSpecialPowerButton(this.actionSpecialPowerButton, 7000, this.scenePane, this.playerModel,
                this.systemModel);

        this.playerModel.loadImageFromSpriteList();
        this.systemModel.loadImageFromSpriteList();


        this.playerModel.playSpriteAnimation();
        this.systemModel.playSpriteAnimation();
        this.animationHudDisplays();
        this.mainLoop();
    }

    public void exitAppButtonEvent() {
        Screen10ThanksgivingController controller =
                (Screen10ThanksgivingController)  SceneHandler.screen10ThanksgivingModel.getController();

        controller.setCanItStopApp(true);
        SceneHandler.getCurrentStage().setScene(SceneHandler.screen10ThanksgivingModel.getScene());
    }

    private void fillPlayerCharacterModel() {
        this.playerModel = new PlayerCharacterModel("Player 01", "/images/animations/player_idle_01.png",
                1000);

        this.playerModel.setCharacterImaveView(this.playerImageView);
        this.playerModel.setStatusLabel(this.playerStatusText);

        this.playerModel.setCurrentState(AnimationStateEnum.IDLE);

        this.playerModel.setHealthPower(2500);
        this.playerModel.setStaminaPower(700);

        this.playerModel.setAttackPower(300);
        this.playerModel.setDefensePower(270);
        this.playerModel.setDodgeValue(150);
        this.playerModel.setEnergyRecovery(300);
        this.playerModel.setSpecialPower(1000);



        this.playerModel.loadImageFromSpriteList();

    }
    private void fillSystemCharacterModel() {
        this.systemModel = new SystemCharacterModel("System", "/images/animations/system_idle_01.png", 1500);
        this.systemModel.setCharacterImaveView(this.systemImageView);
        this.systemModel.setStatusLabel(this.systemStatusText);


        this.systemModel.setCurrentState(AnimationStateEnum.IDLE);

        this.systemModel.setHealthPower(5000);
        this.systemModel.setStaminaPower(300);

        this.systemModel.setAttackPower(350);
        this.systemModel.setDefensePower(270);
        this.systemModel.setDodgeValue(150);
        this.systemModel.setEnergyRecovery(20);
        this.systemModel.setSpecialPower(1000);

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
        long animationDelay = (long) ((float)(.3 ) * 1_000_000_000l);
        this.hudElapsedTime = 0L;

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(hudElapsedTime > now) return;

                hudElapsedTime = now + animationDelay;

                double playerHpHUDWidth =
                        playerHPBackgroundRect.getWidth() * playerModel.getHealthPowerPercent();
                double systemHpHUDWidth =
                        systemHPBackgroundRect.getWidth() * systemModel.getHealthPowerPercent();

                playerHPForegroundRect.setWidth(playerHpHUDWidth);
                systemHPForegroundRect.setWidth(systemHpHUDWidth);

                double playerSpHUDWidth = playerHPBackgroundRect.getWidth() * playerModel.getStaminaPowerPercent();
                double systemSpHUDWidth = systemHPBackgroundRect.getWidth() * systemModel.getStaminaPowerPercent();

                playerSPForegroundRect.setWidth(playerSpHUDWidth);
                systemSPForegroundRect.setWidth(systemSpHUDWidth);

                if(getIsItReleaseAnimationTimers()) {
                    this.stop();
                }
            }
        };

        animationTimer.start();

    }

    public void mainLoop() {
        this.mainLoopElpasedTime = 0;

        this.mainLoopAnimationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(mainLoopElpasedTime > now) return;

                mainLoopElpasedTime = now + 300_000_000l;

                if(playerModel.getCurrentState() == AnimationStateEnum.IDLE) {
                    playerModel.changeStamina(-1 * AnimationStateStaminaCostEnum.IDLE.getCost());
                }

                if(systemModel.getCurrentState() == AnimationStateEnum.IDLE) {
                    systemModel.changeStamina(-1 * AnimationStateStaminaCostEnum.IDLE.getCost());
                }

                if(playerModel.getCurrentState() == AnimationStateEnum.ENERGY) {
                    playerModel.changeStamina(playerModel.getEnergyRecovery());
                    playerModel.changeHealth(playerModel.getEnergyRecovery() / 3);
                }

                if(systemModel.getCurrentState() == AnimationStateEnum.ENERGY) {
                    systemModel.changeStamina(systemModel.getEnergyRecovery());
                    systemModel.changeHealth(systemModel.getEnergyRecovery() / 2);
                }

                if(systemModel.getCurrentHealthPower() <= 0) {
                    isPlayerWinState = GameStateEnum.PLAYER_WIN;

                } else if(playerModel.getCurrentHealthPower() <= 0) {
                    isPlayerWinState = GameStateEnum.PLAYER_LOST;
                }

                goToEndGameScene();
                if(getIsItReleaseAnimationTimers()) {
                    this.stop();
                }
            }
        };
        this.mainLoopAnimationTimer.start();

    }



    public void goToEndGameScene() {
        if(isPlayerWinState != GameStateEnum.PLAYER_WIN && isPlayerWinState != GameStateEnum.PLAYER_LOST) return;

        AppSettings.setIsPlayerWin(this.isPlayerWinState);
        this.mainLoopAnimationTimer.stop();

        this.playerModel.stopAllAnimationTimers();
        this.systemModel.stopAllAnimationTimers();

        SceneHandler.getCurrentStage().setScene(SceneHandler.screen09EndGameModel.getScene());

        this.setItReleaseAnimationTimers(true);
    }


    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    public Label getSystemNameLabel() {
        return systemNameLabel;
    }
}
