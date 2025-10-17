module br.com.senai.group1.appproject.appproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.compiler;


    opens br.com.senai.group1.appproject.appproject to javafx.fxml;
    opens br.com.senai.group1.appproject.appproject.controllers to javafx.fxml;
    exports br.com.senai.group1.appproject.appproject;
    exports br.com.senai.group1.appproject.appproject.controllers;
}