package br.com.senai.group1.appproject.appproject.models;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;

import java.util.Random;
import java.util.function.Consumer;

public class AnimationUtils {

    public static void executeAfterTime(int delayMilliseconds, Runnable runnable)
    {
        long delayTime = (long) delayMilliseconds * 1_000_000l + System.nanoTime();
        (new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(delayTime > now) return;

                runnable.run();
                this.stop();
            }
        }).start();

    }

    public static AnimationStateEnum getRandomizeAnimationAction(AnimationStateEnum[] animationList) {
        Random random = new Random();
        int randomValue = random.nextInt(animationList.length);

        AnimationStateEnum state = animationList[randomValue];

        return state;
    }
}
