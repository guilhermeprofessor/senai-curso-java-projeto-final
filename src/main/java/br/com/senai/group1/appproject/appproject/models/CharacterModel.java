package br.com.senai.group1.appproject.appproject.models;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CharacterModel {
    private String name;
    private String imageUri;
    private Label statusLabel;
    private ImageView characterImaveView;

    private double healthPower = 1000;
    private double currentHealthPower = 1000;
    private double staminaPower = 300;
    private double currentStaminaPower = 300;

    private double attackPower = 100;
    private double defensePower = 100;
    private double dodgeValue = 100;
    private double specialPower = 300;
    private double energyRecovery = 30;

    public CharacterModel(String name, String imageUri) {
        this.name = name;
        this.imageUri = imageUri;
    }

    public double getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(double healthPower) {
        this.healthPower = healthPower;
    }

    public void changeHealth(double value) {
        this.currentHealthPower += value;

        if(this.currentHealthPower < 0) this.currentHealthPower = 0;
        else if(this.currentHealthPower > this.staminaPower) this.currentHealthPower = this.healthPower;
    }

    public double getStaminaPower() {
        return staminaPower;
    }

    public void setStaminaPower(double staminaPower) {
        this.staminaPower = staminaPower;
    }

    public void changeStamina(double value) {
        this.currentStaminaPower += value;

        if(this.currentStaminaPower < 0) this.currentStaminaPower = 0;
        else if(this.currentStaminaPower > this.staminaPower) this.currentStaminaPower = this.staminaPower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(double defensePower) {
        this.defensePower = defensePower;
    }

    public double getDodgeValue() {
        return dodgeValue;
    }

    public void setDodgeValue(double dodgeValue) {
        this.dodgeValue = dodgeValue;
    }

    public double getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(double specialPower) {
        this.specialPower = specialPower;
    }

    public double getEnergyRecovery() {
        return energyRecovery;
    }

    public void setEnergyRecovery(double energyRecovery) {
        this.energyRecovery = energyRecovery;
    }



    public String getName() {
        return name;
    }

    public String getImageUri() {
        return imageUri;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    public ImageView getCharacterImaveView() {
        return characterImaveView;
    }

    public void setCharacterImaveView(ImageView characterImaveView) {
        this.characterImaveView = characterImaveView;
    }

}
