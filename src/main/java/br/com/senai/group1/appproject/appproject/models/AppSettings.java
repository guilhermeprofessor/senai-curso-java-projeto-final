package br.com.senai.group1.appproject.appproject.models;

import javafx.scene.media.MediaPlayer;

public class AppSettings {

    private static GameStateEnum isPlayerWin = GameStateEnum.UNDEFINED;
    private static GameStateEnum isPlaying = GameStateEnum.UNDEFINED;
    private static String playerName = "";

    private static MediaPlayer backgroundMediaPlayer = null;
    private static MediaPlayer foregroundMediaPlayer = null;

    private static double musicVolume = .25;
    private static double effectVolume = .25;


    public static GameStateEnum getIsPlayerWin() {
        return isPlayerWin;
    }

    public static void setIsPlayerWin(GameStateEnum isPlayerWin) {
        switch(isPlayerWin) {
            case PLAYER_WIN:
            case PLAYER_LOST:
                AppSettings.isPlayerWin = isPlayerWin;
                break;
            default:
                AppSettings.isPlayerWin = GameStateEnum.UNDEFINED;
        }
    }

    public static GameStateEnum getIsPlaying() {
        return isPlaying;
    }

    public static void setIsPlaying(GameStateEnum isPlaying) {
        switch(isPlayerWin) {
            case GAME_IS_RUNNING:
            case GAME_START:
            case GAME_END:
                AppSettings.isPlayerWin = isPlayerWin;
                break;
            default:
                AppSettings.isPlayerWin = GameStateEnum.UNDEFINED;
        }
    }

    public static String getPlayerName() {
        return AppSettings.playerName;
    }

    public static void setPlayerName(String playerName) {
        AppSettings.playerName = playerName;
    }

    public static void clearPlayerName() {
        AppSettings.setPlayerName("");
    }

    public static MediaPlayer getBackgroundMediaPlayer() {
        return backgroundMediaPlayer;
    }

    public static void setBackgroundMediaPlayer(MediaPlayer backgroundMediaPlayer) {
        AppSettings.backgroundMediaPlayer = backgroundMediaPlayer;
    }

    public static MediaPlayer getForegroundMediaPlayer() {
        return foregroundMediaPlayer;
    }

    public static void setForegroundMediaPlayer(MediaPlayer foregroundMediaPlayer) {
        AppSettings.foregroundMediaPlayer = foregroundMediaPlayer;
    }

    public static double getMusicVolume() {
        return musicVolume;
    }

    public static void setMusicVolume(double musicVolume) {
        AppSettings.musicVolume = musicVolume;
    }

    public static double getEffectVolume() {
        return effectVolume;
    }

    public static void setEffectVolume(double effectVolume) {
        AppSettings.effectVolume = effectVolume;
    }
}
