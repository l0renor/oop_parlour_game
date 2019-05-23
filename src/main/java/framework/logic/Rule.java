package framework.logic;

import framework.data.Board;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Interface to specify different rules for the actions in one turn.
 */
public interface Rule {

    /**
     * Returns the valid types of accessories for the rule's action.
     * @return ArrayList of type AccessoryType.
     */
    ArrayList<AccessoryType> getValidAccessoryTypes();

    /**
     * Manipulates the accessories on the passed board to do the actions this rule represents, using information of the GameState tailored to the Game.
     * @param state An object implementing the GameState interface.
     * @param board The board the Game is run on.
     */
    void setValidActions(GameState state, Board board);

    /**
     * Default implementation to play a sound during the Action.
     * @param path path to the sound file as String.
     */
    default void playSound(String path) {
        Media sound = new Media(path);
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }

}
