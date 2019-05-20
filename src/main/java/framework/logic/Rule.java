package framework.logic;

import framework.data.Board;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public interface Rule {
    ArrayList<AccessoryType> getValidAccessoryTypes();
    void setValidActions(GameState state, Board board);
    default void playSound(String path){
        Media sound = new Media(path);
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}
