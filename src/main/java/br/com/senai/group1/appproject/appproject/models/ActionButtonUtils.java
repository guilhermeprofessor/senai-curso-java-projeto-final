package br.com.senai.group1.appproject.appproject.models;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActionButtonUtils {

    private static List<Button> currentActionButtonList = new ArrayList<>();

    public static List<Button> getCurrentActionButtonList() {
        return currentActionButtonList;
    }

    public static void disableAllButtonInList(List<Button> buttonList, Button clickedButton) {
        Random random = new Random();
        List<Button> disabledButtonList = new ArrayList<>();
        for (Button button : buttonList) {
            if (button == clickedButton) continue;

            if(button.isDisable()) {
                disabledButtonList.add(button);
            }

            button.setDisable(true);
        }

        long delayTime = System.nanoTime() + 1_500_000_000l;
        (new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(delayTime > now) return;

                for (Button button : buttonList) {
                    if (button == clickedButton) continue;

                    if(disabledButtonList.contains(button)) continue;

                    button.setDisable(false);

                    this.stop();
                }
            }
        }).start();


    }


    public static void setDefaultActionToActionButton(Button button, int delayInMilliseconds) {
        button.setDisable(true);
        Random random = new Random();
        ImageView imageView = ButtonUtils.getImageViewFromButton(button);

        ActionButtonUtils.disableAllButtonInList(ActionButtonUtils.getCurrentActionButtonList(), button);
        ActionButtonUtils.addCssClassToNode(imageView, "action-used");

        int delayTime = random.nextInt(delayInMilliseconds) + 1500;
        long waitTime = System.nanoTime() + (1_000_000l * delayTime);

        AnimationTimer animation = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (waitTime > now) return;

                ActionButtonUtils.removeCssClassToNode(imageView, "action-used");
                button.setDisable(false);
                this.stop();
            }
        };

        animation.start();
    }

    public static void setActionToAttackButton(Button button, int delayTime, Node scenePane, CharacterModel mainCharacter, CharacterModel otherCharacter) {

        button.setOnAction((ActionEvent event) -> {
            ActionButtonUtils.setDefaultActionToActionButton(button, delayTime);


//            AnchorPane sceneAnchorPane = ((AnchorPane) scenePane);
//            ImageView targetView = otherCharacter.getCharacterImaveView();

            // carrega imagem do ataque do player no system
//            Image areaSystemImage = ImageUtils.loadInputStream("/images/action-area-effect.png");
//            ImageView systemImageView = new ImageView(areaSystemImage);
//            systemImageView.setFitWidth(targetView.getFitWidth());
//            systemImageView.setFitHeight(targetView.getFitHeight());
//            AnchorPane.setBottomAnchor(systemImageView, AnchorPane.getBottomAnchor(targetView));
//            AnchorPane.setRightAnchor(systemImageView, AnchorPane.getRightAnchor(targetView) - targetView.getFitWidth()/2);



            mainCharacter.setCurrentState(AnimationStateEnum.ATTACK);

            AnimationUtils.executeAfterTime(500,() -> {
//                sceneAnchorPane.getChildren().add(systemImageView);
                otherCharacter.getStatusLabel().setTextFill(Color.RED);

                otherCharacter.getStatusLabel().setText("-"+((int)mainCharacter.getAttackPower())+"");
            });
            AnimationUtils.executeAfterTime(1000,() -> {
//                sceneAnchorPane.getChildren().remove(systemImageView);

                otherCharacter.getStatusLabel().setText("");
            });
        });
    }

    public static void setActionToDefenseButton(Button button, int delayTime, Node scenePane, CharacterModel mainCharacter, CharacterModel otherCharacter) {

        button.setOnAction((ActionEvent event) -> {
            ActionButtonUtils.setDefaultActionToActionButton(button, delayTime);

            mainCharacter.setCurrentState(AnimationStateEnum.DEFENSE);
        });
    }

    public static void setActionToEnergyButton(Button button, int delayTime, Node scenePane, CharacterModel mainCharacter, CharacterModel otherCharacter) {

        button.setOnAction((ActionEvent event) -> {
            ActionButtonUtils.setDefaultActionToActionButton(button, delayTime);

            mainCharacter.setCurrentState(AnimationStateEnum.ENERGY);
        });
    }

    public static void setActionToDodgeButton(Button button, int delayTime, Node scenePane, CharacterModel mainCharacter, CharacterModel otherCharacter) {

        button.setOnAction((ActionEvent event) -> {
            ActionButtonUtils.setDefaultActionToActionButton(button, delayTime);

            mainCharacter.setCurrentState(AnimationStateEnum.DODGE);
        });
    }

    public static void setActionToSpecialPowerButton(Button button, int delayTime, Node scenePane, CharacterModel mainCharacter, CharacterModel otherCharacter) {

        button.setOnAction((ActionEvent event) -> {
            ActionButtonUtils.setDefaultActionToActionButton(button, delayTime);

            mainCharacter.setCurrentState(AnimationStateEnum.SPECIAL_POWER);
        });
    }


    public static void addCssClassToNode(Node node, String cssClass) {
        if (node != null) {
            node.getStyleClass().add(cssClass);
        }
    }

    public static void removeCssClassToNode(Node node, String cssClass) {
        if (node != null) {
            node.getStyleClass().remove(cssClass);
        }
    }
}
