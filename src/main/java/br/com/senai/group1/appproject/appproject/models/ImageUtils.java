package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import javafx.scene.image.Image;

import java.io.InputStream;

public class ImageUtils {

    public final static String SCENE_09_PLAYER_WIN_BACKGROUND = "/images/scenario_win_scene_01.png";
    public final static String SCENE_09_PLAYER_LOST_BACKGROUND = "/images/scenario_lost_scene_01.png";

    public static Image loadInputStream(String imageUri) {
        Image image = null;
        InputStream inputStream;
        try {
            inputStream = MainApplication.class.getResourceAsStream(imageUri);
            if(inputStream != null) {
                image = new Image(inputStream);
                return image;
            } else {
                System.err.println("Imagem não encontrada! Verifique o caminho.");
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
