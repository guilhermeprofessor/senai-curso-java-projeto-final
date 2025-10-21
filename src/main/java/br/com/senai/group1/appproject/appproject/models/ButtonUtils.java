package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.geom.Line2D;
import java.io.InputStream;

public class ButtonUtils {

    private static Point2D actionButtonDefaultDimension = new Point2D(70,70);

    public static Button generateActionButton(String imageUri, String style, String text) {
        Button button = new Button();
        Image image = ImageUtils.loadInputStream(imageUri);

        ImageView imageView = null;
        if(image != null) {
            imageView = new ImageView(image);
            button.setGraphic(imageView);
        } else {
            button.setText(text);
        }


        button.getStyleClass().add(style);
        button.setPrefWidth(ButtonUtils.actionButtonDefaultDimension.getX());
        button.setPrefHeight(ButtonUtils.actionButtonDefaultDimension.getY());

        imageView.setFitWidth(ButtonUtils.actionButtonDefaultDimension.getX() - 4);
        imageView.setFitHeight(ButtonUtils.actionButtonDefaultDimension.getY() - 4);

        return button;
    }

    public static Button generateAmountActionsButton(int number, String text) {
        double width = ButtonUtils.actionButtonDefaultDimension.getX();
        double height = ButtonUtils.actionButtonDefaultDimension.getY();

        Button button = new Button();
        button.getStyleClass().add("button-action-image");
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        button.setMaxWidth(width);
        button.setMaxHeight(height);

        AnchorPane anchorPane = new AnchorPane();
        button.setGraphic(anchorPane);


        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
//        anchorPane.prefWidthProperty().bind(button.widthProperty());
//        anchorPane.prefHeightProperty().bind(button.heightProperty());


        ImageView backgroundImageView = new ImageView();
        Image image = ImageUtils.loadInputStream("/images/icon-button-empty-01.png");
        backgroundImageView.setImage(image);
        backgroundImageView.setPreserveRatio(false);

        backgroundImageView.setFitWidth(width);
        backgroundImageView.setFitHeight(height);
        anchorPane.getChildren().add(backgroundImageView);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);


        anchorPane.getChildren().add(vbox);

        Label actionLabel = new Label();
        Label numberLabel = new Label();

        vbox.getChildren().addAll(actionLabel, numberLabel);

        actionLabel.setText(text);
        numberLabel.setText(number+"x");


        return button;
    }

    public static ImageView getImageViewFromButton(Button button) {
        Node graphic = button.getGraphic();

        if(graphic instanceof ImageView) {
            return (ImageView) graphic;
        }

        return null;
    }

}
