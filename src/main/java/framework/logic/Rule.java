package framework.logic;

import framework.data.Board;
import framework.data.accessories.Accessory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Interface to specify different rules for the actions in one turn.
 */
public interface Rule {

    /**
     * Returns if accessory is valid for the rule's action.
     * @param gameState An object implementing the GameState interface.
     * @param accessory An accessory which was clicked.
     * @return Validity of accessory as boolean.
     */
    boolean isAccessoryValid(GameState gameState, Accessory accessory);

    /**
     * Manipulates the accessories on the passed board to do the actions this rule represents, using information of the GameState tailored to the Game.
     * @param gameState An object implementing the GameState interface.
     * @param board The board the Game is run on.
     */
    void setValidActions(GameState gameState, Board board);

    /**
     * Default implementation to play a sound during the Action.
     * @param path path to the sound file as String.
     */
    default void playSound(String path) {
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}
