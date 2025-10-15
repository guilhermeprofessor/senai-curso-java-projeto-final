package br.com.senai.group1.appproject.appproject.controllers;

import br.com.senai.group1.appproject.appproject.models.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    List<GridPane> gridPaneList = new ArrayList<>();
    int[] gridPanelOrderList = null;

    public Screen07FightController(PreparedSceneModel model) {
        super(model);
    }

    public Screen07FightController(Stage stage) {
        super(stage);
    }

    public long elapsedTime = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.populateButtonList();
        this.populateGridPaneList();



        elapsedTime = 0L;
        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(elapsedTime > now) return;

                elapsedTime = now + 5_000_000_000l;
                insertAndPositionsButtonsInGrids();
            }

        };

        animationTimer.start();
    }

    public void populateButtonList() {
        Button buttonAttack = ButtonUtils.generateActionButton("/images/button-atack.png","button-action-image", "1");
        Button buttonDefense = ButtonUtils.generateActionButton("/images/button-defend-01.png","button-action-image", "2");
        Button buttonDodge = ButtonUtils.generateActionButton("/images/button-dodge-01.png","button-action-image", "3");
        Button buttonEnergy = ButtonUtils.generateActionButton("/images/button-energy-01.png","button-action-image", "4");
        Button buttonSpecial = ButtonUtils.generateActionButton("/images/button-special-power-01.png","button-action-image", "5");

        this.actionButtonList.add(buttonAttack);
        this.actionButtonList.add(buttonDefense);
        this.actionButtonList.add(buttonEnergy);
        this.actionButtonList.add(buttonDodge);
        this.actionButtonList.add(buttonSpecial);
    }

    public void changeActionButtonImageToTimeNumberImage() {

    }

    public void populateGridPaneList() {
        this.gridPaneList.add(this.sorterRegion0GridPane);
        this.gridPaneList.add(this.sorterRegion1GridPane);
        this.gridPaneList.add(this.sorterRegion2GridPane);
        this.gridPaneList.add(this.sorterRegion3GridPane);
        this.gridPaneList.add(this.sorterRegion4GridPane);
    }

    public int[] generateOrderIndexList() {
        int[] orderList = RandomizeValuesUtils.randomUnrepeatedPosition(this.gridPaneList.size());
        int[] newOrderList = new int[orderList.length];

        for(int i = 0; i < orderList.length; i++) {
            newOrderList[i] = orderList[i] -1;
        }

        Arrays.stream(orderList).forEach(number -> System.out.print(number+" "));
        System.out.println();
        Arrays.stream(newOrderList).forEach(number -> System.out.print(number + " "));
        System.out.println();

        System.out.println("================");

        return newOrderList;
    }

    public void insertAndPositionsButtonsInGrids() {
        int[] orderList = this.generateOrderIndexList();

        this.removeButtonFromGridPaneList();

        GridPane gridPane;
        for(int i = 0; i < this.actionButtonList.size(); i++) {
            Button button = this.actionButtonList.get(i);

            gridPane = this.gridPaneList.get(orderList[i]);
            gridPane.add(button,0,0);
            gridPane.setHalignment(button, RandomizeValuesUtils.randomizeHPosEnumValue());
            gridPane.setValignment(button, RandomizeValuesUtils.randomizeVPosEnumValue());
        }


    }

    public void removeButtonFromGridPaneList() {
        for(GridPane gridPane : this.gridPaneList) {
            gridPane.getChildren().clear();
        }
    }

}
