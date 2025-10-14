package br.com.senai.group1.appproject.appproject.models;

public class ActionButtonModel {
    private String imageUri;
    private String word;
    private ButtonActionEvent buttonActionEvent;


    public class ButtonActionEvent {
        public ButtonActionValue actionValue;
        
    }

    public enum ButtonActionValue {
        ATTACK, DEFEND, DODGE, ENERGY, SPECIAL
    }
}
