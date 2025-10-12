module br.com.senai.group1.appproject.appproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;
    requires javafx.graphics;


    opens br.com.senai.group1.appproject.appproject to javafx.fxml;
    exports br.com.senai.group1.appproject.appproject;
    exports br.com.senai.group1.appproject.appproject.controllers;
    opens br.com.senai.group1.appproject.appproject.controllers to javafx.fxml;
}