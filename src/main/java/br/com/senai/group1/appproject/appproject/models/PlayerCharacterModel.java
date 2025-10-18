package br.com.senai.group1.appproject.appproject.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerCharacterModel extends CharacterModel {
    public PlayerCharacterModel(String name, String imageUri) {
        super(name, imageUri);

        this.setCurrentState(AnimationStateEnum.IDLE);
    }


    @Override
    public void fillAnimationSpriteList() {
        HashMap<AnimationStateEnum, List<String>> map = this.getSpriteList();

        List<String> idleSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.IDLE, idleSpriteList);

        idleSpriteList.add("/images/animations/player_idle_01.png");
        idleSpriteList.add("/images/animations/player_idle_02.png");
        idleSpriteList.add("/images/animations/player_idle_03.png");



        List<String> defenseSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.DEFENSE, defenseSpriteList);

        defenseSpriteList.add("/images/animations/player_defense_01.png");



        List<String> attackSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.ATTACK, attackSpriteList);

        attackSpriteList.add("/images/animations/player_attack_01.png");
        attackSpriteList.add("/images/animations/player_attack_02.png");


        List<String> energySpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.ENERGY, energySpriteList);

        energySpriteList.add("/images/animations/player_energy_01.png");
        energySpriteList.add("/images/animations/player_energy_02.png");


        List<String> dodgeSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.DODGE, dodgeSpriteList);

        dodgeSpriteList.add("/images/animations/player_dodge_01.png");


        List<String> specialPowerSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.SPECIAL_POWER, specialPowerSpriteList);

        specialPowerSpriteList.add("/images/animations/player_special_01.png");
        specialPowerSpriteList.add("/images/animations/player_special_02.png");
        specialPowerSpriteList.add("/images/animations/player_special_03.png");
        specialPowerSpriteList.add("/images/animations/player_special_04.png");
    }

    @Override
    public void fillSpriteSequenceList() {
        this.getSpriteSequenceList().put(AnimationStateEnum.IDLE, new int[]{0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1
                ,0,0,0,0,2,2,2,2});

        this.getSpriteSequenceList().put(AnimationStateEnum.ATTACK, new int[]{0,0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.DAMAGE, new int[]{0,0,1,1,0,0,1,1});

        this.getSpriteSequenceList().put(AnimationStateEnum.DEFENSE, new int[]{0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.DODGE, new int[]{0,0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.ENERGY, new int[]{0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1});

        this.getSpriteSequenceList().put(AnimationStateEnum.SPECIAL_POWER, new int[]{0,1,2,1,2,1,2,1,2,1,2,3});



    }
}
