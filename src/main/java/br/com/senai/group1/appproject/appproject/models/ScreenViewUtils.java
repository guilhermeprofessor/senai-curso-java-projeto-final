package br.com.senai.group1.appproject.appproject.models;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenViewUtils {

    public static final String SCREEN_01_OPENING_FXML = "/views/screen-01-opening.fxml";
    public static final String SCREEN_02_MENU_FXML = "/views/screen-02-menu.fxml";
    public static final String SCREEN_03_SETTINGS_FXML = "/views/screen-03-settings.fxml";
    public static final String SCREEN_04_TUTORIAL_FXML = "/views/screen-04-tutorial.fxml";
    public static final String SCREEN_05_SELECT_PLAYER_FXML = "/views/screen-05-select-player.fxml";
    public static final String SCREEN_06_DIALOGS_FXML = "/views/screen-06-dialogs.fxml";
    public static final String SCREEN_07_FIGHT_FXML = "/views/screen-07-fight.fxml";
    public static final String SCREEN_08_CREDITS_FXML = "/views/screen-08-credits.fxml";

    private static double screenWidth = 0;
    private static double screenHeight = 0;
    private static double minDimension = 400;

    public static Rectangle2D getThePositionToCenterTheScreen() {
        Screen screen = Screen.getPrimary();
        Rectangle2D boundValues = screen.getBounds();

        Rectangle2D newPosition = new Rectangle2D(
            0,
            0,
            (boundValues.getWidth() / 2) - ScreenViewUtils.getScreenWidth() / 2,
            (boundValues.getHeight() / 2) - ScreenViewUtils.getScreenHeight() / 2
        );

        return newPosition;
    }


    public static double getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(double value) {
        ScreenViewUtils.screenWidth = value > ScreenViewUtils.minDimension ? value : ScreenViewUtils.minDimension;
    }

    public static double getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(double value) {
        ScreenViewUtils.screenHeight = value > ScreenViewUtils.minDimension ? value : ScreenViewUtils.minDimension;
    }
}
