package br.com.senai.group1.appproject.appproject.models;

public enum AnimationStateStaminaCostEnum {
    ATTACK(10, AnimationStateEnum.ATTACK),
    DAMAGE(0, AnimationStateEnum.DAMAGE),
    DEFENSE(5, AnimationStateEnum.DEFENSE),
    DODGE(1, AnimationStateEnum.DODGE),
    ENERGY(-25, AnimationStateEnum.ENERGY),
    IDLE(-.5, AnimationStateEnum.IDLE),
    SPECIAL_POWER(100, AnimationStateEnum.SPECIAL_POWER);


    private double cost = 0;
    private AnimationStateEnum state = AnimationStateEnum.IDLE;
    private AnimationStateStaminaCostEnum(double cost, AnimationStateEnum state) {
        this.cost = cost;
        this.state = state;
    }

    public double getCost() {
        return this.cost;
    }
    public AnimationStateEnum getState() {
        return this.state;
    }
}
