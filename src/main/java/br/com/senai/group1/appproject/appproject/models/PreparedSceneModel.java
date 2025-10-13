package br.com.senai.group1.appproject.appproject.models;

import br.com.senai.group1.appproject.appproject.MainApplication;
import br.com.senai.group1.appproject.appproject.controllers.ScreenBaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PreparedSceneModel {
    private FXMLLoader fxmlLoader;
    private Parent parent;
    private Scene scene;
    private ScreenBaseController screenBaseController;
    private Stage stage;


    public PreparedSceneModel(Stage stage, String viewPath, ScreenBaseController controller) throws IOException {
        this.stage = stage;
        this.screenBaseController = controller;

        this.fxmlLoader = new FXMLLoader(MainApplication.class.getResource(viewPath));;
        this.fxmlLoader.setController(this.screenBaseController);



        Scene scene = new Scene(new VBox());

        this.scene = new Scene(new VBox(), ScreenViewUtils.getScreenWidth(), ScreenViewUtils.getScreenHeight());

        this.getScreenBaseController().setScene(this.scene);

        this.parent = this.fxmlLoader.load();
        this.scene.setRoot(this.parent);
        this.getScreenBaseController().setScene(this.scene);
        this.getScreenBaseController().resizeBackgroundImageByBind();
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ScreenBaseController getScreenBaseController() {
        return screenBaseController;
    }

//    public void setScreenBaseController(ScreenBaseController screenBaseController) throws IOException {
//        this.screenBaseController = screenBaseController;
//
//        this.fxmlLoader.setController(this.screenBaseController);
//
//        this.parent = this.fxmlLoader.getRoot();
//        this.scene = new Scene(this.parent, ScreenViewUtils.getScreenWidth(), ScreenViewUtils.getScreenHeight());
//    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
