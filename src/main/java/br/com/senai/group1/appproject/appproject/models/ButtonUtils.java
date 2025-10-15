package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ButtonUtils {

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
        button.setPrefWidth(70);
        button.setPrefHeight(70);

        imageView.setFitWidth(70 - 4);
        imageView.setFitHeight(70 - 4);

        return button;
    }

}
