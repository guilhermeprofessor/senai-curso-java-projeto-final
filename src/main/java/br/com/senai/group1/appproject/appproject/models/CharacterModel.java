package br.com.senai.group1.appproject.appproject.models;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CharacterModel {
    private String name;
    private String imageUri;
    private Label statusLabel;

    private ImageView characterImaveView;
    private Image currentSpriteImage;
    private AnimationStateEnum currentState;
    private int currentSriteIndex = 0;
    private AnimationTimer spriteAnimationTimer;
    private long elapsedTime = 0;


    private double healthPower = 1000;
    private double currentHealthPower = 1000;
    private double staminaPower = 300;
    private double currentStaminaPower = 300;

    private double attackPower = 100;
    private double defensePower = 100;
    private double dodgeValue = 100;
    private double specialPower = 300;
    private double energyRecovery = 30;

    private HashMap<AnimationStateEnum, List<String>> spriteList = new HashMap<>();
    private HashMap<AnimationStateEnum, List<Image>> imageList = new HashMap<>();
    private HashMap<AnimationStateEnum, int[]> spriteSequenceList = new HashMap<>();

    public CharacterModel(String name, String imageUri) {
        this.name = name;
        this.imageUri = imageUri;

        this.fillAnimationSpriteList();
        this.fillSpriteSequenceList();
    }

    public void loadImageFromSpriteList() {
        this.imageList = new HashMap<>();

        for(AnimationStateEnum enumValue : this.spriteList.keySet()) {
            List<Image> imageList = new ArrayList<>();
            for(String uri : this.spriteList.get(enumValue)) {
                Image image = ImageUtils.loadInputStream(uri);

                if(image == null) continue;

                imageList.add(image);
            }

            this.imageList.put(enumValue, imageList);
        }

    }

    public void playSpriteAnimation() {
        if(this.spriteAnimationTimer != null) this.spriteAnimationTimer.stop();

        long animationDelay = (long) ((float)(.1 ) * 1_000_000_000l);
        this.elapsedTime = 0L;
        this.spriteAnimationTimer =  new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTime > now) return;

                elapsedTime = now + animationDelay;

                List<Image> animationSpriteList = imageList.get(currentState);

                if(animationSpriteList == null) return;

                currentSriteIndex ++;

                if(currentSriteIndex >= spriteSequenceList.get(currentState).length) {
                    currentSriteIndex = 0;
                    currentState = AnimationStateEnum.IDLE;
                }

                int spriteIndex = spriteSequenceList.get(currentState)[currentSriteIndex];

                currentSpriteImage = animationSpriteList.get(spriteIndex);
                characterImaveView.setImage(currentSpriteImage);
            }
        };

        this.spriteAnimationTimer.start();
    }

    public abstract void fillAnimationSpriteList();

    public abstract void fillSpriteSequenceList();

    public double getHealthPowerPercent() {
        double percent = this.currentHealthPower / this.healthPower;
        if(percent < 0) return 0;
        if(percent > 1) return 1;

        return percent;
    }

    public double getStaminaPowerPercent() {
        double percent = this.currentStaminaPower / this.staminaPower;

        if(percent < 0) return 0;
        if(percent > 1) return 1;

        return percent;
    }


    public HashMap<AnimationStateEnum, int[]> getSpriteSequenceList() {
        return spriteSequenceList;
    }

    public void setSpriteSequenceList(HashMap<AnimationStateEnum, int[]> spriteSequenceList) {
        this.spriteSequenceList = spriteSequenceList;
    }

    public void setImageList(HashMap<AnimationStateEnum, List<Image>> imageList) {
        this.imageList = imageList;
    }

    public void setSpriteList(HashMap<AnimationStateEnum, List<String>> spriteList) {
        this.spriteList = spriteList;
    }

    public AnimationStateEnum getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AnimationStateEnum currentState) {
        this.currentSriteIndex = 0;
        this.currentState = currentState;
    }

    public Image getCurrentSpriteImage() {
        return currentSpriteImage;
    }

    public void setCurrentSpriteImage(Image currentSpriteImage) {
        if(currentSpriteImage == null) return;

        this.currentSpriteImage = currentSpriteImage;
    }

    public HashMap<AnimationStateEnum, List<Image>> getImageList() {
        return imageList;
    }

    public double getCurrentHealthPower() {
        return currentHealthPower;
    }

    public double getCurrentStaminaPower() {
        return currentStaminaPower;
    }

    public HashMap<AnimationStateEnum, List<String>> getSpriteList() {
        return spriteList;
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
