package br.com.senai.group1.appproject.appproject.models;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageViewUtils {

    public static void resizeImageByBind(ImageView imageView, Scene scene) {
        ImageViewUtils.resizeImageByBind(imageView, scene, false);
    }
    public static void resizeImageByBind(ImageView imageView, Scene scene, boolean preserveRatio) {
        imageView.setPreserveRatio(preserveRatio);
        imageView.setSmooth(true);

        imageView.fitWidthProperty().bind(scene.widthProperty());
        imageView.fitHeightProperty().bind(scene.heightProperty());
    }
}
