package br.com.senai.group1.appproject.appproject.models;

public class AppSettings {

    private static GameStateEnum isPlayerWin = GameStateEnum.UNDEFINED;
    private static GameStateEnum isPlaying = GameStateEnum.UNDEFINED;
    private static String playerName = "";


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
}
