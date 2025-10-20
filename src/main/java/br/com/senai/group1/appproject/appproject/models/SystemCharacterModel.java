package br.com.senai.group1.appproject.appproject.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemCharacterModel extends CharacterModel {
    public SystemCharacterModel(String name, String imageUri, int changeAnimationStateDelayMillisecondsValue) {
        super(name, imageUri, changeAnimationStateDelayMillisecondsValue);

        this.setCurrentState(AnimationStateEnum.IDLE);
    }


    @Override
    public void fillAnimationSpriteList() {
        HashMap<AnimationStateEnum, List<String>> map = this.getSpriteList();

        List<String> idleSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.IDLE, idleSpriteList);

        idleSpriteList.add("/images/animations/system_idle_01.png");
        idleSpriteList.add("/images/animations/system_idle_02.png");



        List<String> damageSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.DAMAGE, damageSpriteList);

        damageSpriteList.add("/images/animations/system_damage_01.png");
        damageSpriteList.add("/images/animations/system_damage_02.png");


        List<String> defenseSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.DEFENSE, defenseSpriteList);

        defenseSpriteList.add("/images/animations/system_defense_01.png");



        List<String> attackSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.ATTACK, attackSpriteList);

        attackSpriteList.add("/images/animations/system_attack_01.png");


        List<String> energySpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.ENERGY, energySpriteList);

        energySpriteList.add("/images/animations/system_energy_01.png");
        energySpriteList.add("/images/animations/system_energy_02.png");


        List<String> dodgeSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.DODGE, dodgeSpriteList);

        dodgeSpriteList.add("/images/animations/system_dodge_01.png");


        List<String> specialPowerSpriteList = new ArrayList<>();
        map.put(AnimationStateEnum.SPECIAL_POWER, specialPowerSpriteList);

        specialPowerSpriteList.add("/images/animations/system_special_01.png");
        specialPowerSpriteList.add("/images/animations/system_special_02.png");
        specialPowerSpriteList.add("/images/animations/system_special_03.png");
        specialPowerSpriteList.add("/images/animations/system_special_04.png");
    }

    @Override
    public void fillSpriteSequenceList() {

        this.getSpriteSequenceList().put(AnimationStateEnum.IDLE, new int[]{0,0,0,1,1,1});

        this.getSpriteSequenceList().put(AnimationStateEnum.ATTACK, new int[]{0,0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.DAMAGE, new int[]{0,0,1,1,0,0,1,1});

        this.getSpriteSequenceList().put(AnimationStateEnum.DEFENSE, new int[]{0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.DODGE, new int[]{0,0,0,0,0,0,0,0,0,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.ENERGY, new int[]{0,1,0,1,0,1,0,1,1,1,0});

        this.getSpriteSequenceList().put(AnimationStateEnum.SPECIAL_POWER, new int[]{0,1,2,1,2,1,2,1,2,1,2,3});

    }

    public AnimationStateEnum getRandomizeActionByAction(CharacterModel playerModel) {
        AnimationStateEnum state = null;

        switch(playerModel.getCurrentState()) {
            case IDLE:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                       AnimationStateEnum.ENERGY,
                       AnimationStateEnum.ENERGY,
                       AnimationStateEnum.SPECIAL_POWER
                });
                break;
            case ATTACK:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.SPECIAL_POWER,
                        AnimationStateEnum.DEFENSE,
                        AnimationStateEnum.DEFENSE
                });
                break;
            case DEFENSE:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.ENERGY,
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
            case DODGE:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.ENERGY,
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
            case ENERGY:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.ENERGY,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
            case SPECIAL_POWER:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.DEFENSE,
                        AnimationStateEnum.DEFENSE,
                        AnimationStateEnum.DODGE,
                        AnimationStateEnum.DODGE,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
            case DAMAGE:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
            default:
                state = AnimationUtils.getRandomizeAnimationAction(new AnimationStateEnum[]{
                        AnimationStateEnum.ATTACK,
                        AnimationStateEnum.SPECIAL_POWER
                });
                break;
        }
        return state;
    }
}
