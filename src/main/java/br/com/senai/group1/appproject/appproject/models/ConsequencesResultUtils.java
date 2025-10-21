package br.com.senai.group1.appproject.appproject.models;

import java.util.Random;

public class ConsequencesResultUtils {

    public static int calculateDamageValue(CharacterModel target, CharacterModel other) {
        Random random = new Random();

        int attackValue = 0;

        switch(other.getCurrentState()) {
            case ATTACK: attackValue = random.nextInt((int)other.getAttackPower()); break;
            case SPECIAL_POWER: attackValue = random.nextInt((int)(other.getSpecialPower()*0.7)) + ((int) (other.getSpecialPower() *0.3)); break;
            default: attackValue = 0;
        }


        int defenseValue = (int) target.getDefensePower();

        switch(target.getCurrentState()) {
            case DEFENSE: defenseValue = random.nextInt(defenseValue) + ((int) (defenseValue * .2)); break;
            case DODGE:
                int dodge = random.nextInt((int) target.getDodgeValue());
                attackValue = dodge > (int) (target.getDodgeValue() * .3) ? 0 : attackValue;
                defenseValue = 0;
                break;
            default: defenseValue = 0;
        }


        int result = attackValue - defenseValue;

        return result;
    }


}
