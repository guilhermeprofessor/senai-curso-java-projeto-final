package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
    private GridPane playerGridPane;
    @FXML
    private AnchorPane scenePane;



    @FXML
    private ImageView playerImageView;
    @FXML
    private Label playerStatusText;

    @FXML
    private ImageView systemImageView;
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
        ActionButtonUtils.setActionToDefenseButton(this.actionDefenseButton, 3500);
        ActionButtonUtils.setActionToEnergyButton(this.actionEnergyButton, 2500);
        ActionButtonUtils.setActionToDodgeButton(this.actionDodgeButton, 1500);
        ActionButtonUtils.setActionToSpecialPowerButton(this.actionSpecialPowerButton, 10000);



    }

    private void fillPlayerCharacterModel() {
        this.playerModel = new CharacterModel("Player 01", "/images/player_peq.png");
        this.playerModel.setCharacterImaveView(this.playerImageView);
        this.playerModel.setStatusLabel(this.playerStatusText);

    }
    private void fillSystemCharacterModel() {
        this.systemModel = new CharacterModel("System", "/images/player_peq.png");
        this.systemModel.setCharacterImaveView(this.systemImageView);
        this.systemModel.setStatusLabel(this.systemStatusText);
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





}
