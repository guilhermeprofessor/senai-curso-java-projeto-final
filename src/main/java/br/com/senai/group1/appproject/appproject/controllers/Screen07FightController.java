package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.CharacterModel;
import br.com.senai.group1.appproject.appproject.models.PreparedSceneModel;
import br.com.senai.group1.appproject.appproject.models.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Screen07FightController extends ScreenBaseController {



    @FXML
    private StackPane container;

    @FXML
    private GridPane playerGridPane;

    @FXML
    private GridPane sorterGridPane;

    @FXML
    private GridPane sorterRegion0GridPane;

    @FXML
    private GridPane sorterRegion1GridPane;

    @FXML
    private GridPane sorterRegion2GridPane;

    @FXML
    private GridPane sorterRegion3GridPane;

    @FXML
    private GridPane sorterRegion4GridPane;

    @FXML
    private GridPane systemGridPane;


    List<Button> actionButtonList = new ArrayList<>();

    public Screen07FightController(PreparedSceneModel model) {
        super(model);
    }

    public Screen07FightController(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void populateButtonList() {

    }

}
