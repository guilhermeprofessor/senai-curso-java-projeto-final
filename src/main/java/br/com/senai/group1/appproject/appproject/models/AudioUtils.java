package br.com.senai.group1.appproject.appproject.models;


import br.com.senai.group1.appproject.appproject.MainApplication;
import javafx.animation.AnimationTimer;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URISyntaxException;

public class AudioUtils {

    public static String BATTLE_SOUND = "/audios/battle-of-legends-cinematic-rock-290714.mp3";
    public static String DESERT_SOUND = "/audios/mixkit-ambient-sound-in-the-desert-2488.mp3";
    public static String DEFENSE_SOUND = "/audios/mixkit-weak-hit-impact-2148.mp3";
    public static String ENERGY_SOUND = "/audios/mixkit-magical-light-moving-2584.mp3";
    public static String OPENING_SOUND = "/audios/powerfull-epical-forse-408115.mp3";
    public static String PUNCH_PLAYER_SOUND = "/audios/punch-player-01.mp3";
    public static String PUNCH_SYSTEM_SOUND = "/audios/punch-system.mp3";
    public static String SPECIAL_PLAYER_SOUND = "/audios/mixkit-epic-impact-afar-explosion-2782.mp3";
    public static String SPECIAL_SYSTEM_SOUND = "/audios/mixkit-multiple-fireworks-explosions-1689.mp3";

    private static long elapsedTransitionTime = 0l;


    public static Media loadMedia(String path) {
        Media media = null;
        try {
            File file = new File(MainApplication.class.getResource(path).toURI());

            String fileUri = file.toURI().toString();

            media = new Media(fileUri);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return media;
    }

    public static AudioClip getAudioClipByPath(String path, double volume) {
        AudioClip audioClip = null;
        try {
            audioClip = new AudioClip(path);
            audioClip.setVolume(volume);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return audioClip;
    }

    public static MediaPlayer getMediaPlayerByPath(String path, double volume) {
        Media media = AudioUtils.loadMedia(path);

        MediaPlayer mediaPlayer = null;
        try {
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(volume);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return mediaPlayer;
    }

    public static void changeMediaWithDecay(MediaPlayer oldMedia, double targetValue, long interval) {
        if(oldMedia == null) return;

        oldMedia.setCycleCount(1);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(elapsedTransitionTime > now) return;

                elapsedTransitionTime = now + interval;

                oldMedia.setVolume(oldMedia.getVolume() - 0.001);

                if(oldMedia.getVolume() <= targetValue) {
                    oldMedia.stop();
                    this.stop();
                }
            }
        };

        animationTimer.start();
    }

    public static void playAudioClipByAnimationStateEnum(CharacterModel model) {
        AnimationStateEnum action = model.getCurrentState();

        String path = null;
        switch(action) {
            case ATTACK:
                if(model instanceof SystemCharacterModel) {
                    path = AudioUtils.PUNCH_SYSTEM_SOUND;

                } else {
                    path = AudioUtils.PUNCH_PLAYER_SOUND;
                }
                break;
            case DEFENSE:
                path = AudioUtils.DEFENSE_SOUND;
                break;
            case DODGE:
                path = AudioUtils.DEFENSE_SOUND;

                break;
            case ENERGY:
                path = AudioUtils.ENERGY_SOUND;
                break;
            case SPECIAL_POWER:
                if(model instanceof SystemCharacterModel) {
                    path = AudioUtils.SPECIAL_SYSTEM_SOUND;

                } else {
                    path = AudioUtils.SPECIAL_PLAYER_SOUND;
                }
                break;
        }

        if(path == null) return;

        AudioClip audioClip = null;
        try {
            audioClip = AudioUtils.getAudioClipByPath(MainApplication.class.getResource(path).toURI().toString(),
                    AppSettings.getEffectVolume());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if(audioClip == null) return;

        audioClip.play();
        audioClip.setCycleCount(1);



    }

}
