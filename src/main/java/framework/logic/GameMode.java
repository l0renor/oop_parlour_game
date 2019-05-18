package framework.logic;

import framework.data.Board;

import java.util.ArrayList;

/**
 * Interface to specify the game mode (strategy pattern)
 */
public interface GameMode {

    /**
     * Indicates the set number of players for the individual game mode.
     * @return number of players as 'int'.
     */
    int getNumberOfPlayers();

    /**
     * Constructs a player, can be inheriting class from Player.
     * @return constructed Player object.
     */
    Player constructPlayer();

    /**
     * Returns the list with all ruleset, each corresponding to one Action in a turn.
     * @return ArrayList with Rule.
     */
    ArrayList<Rule> getRules();

    Board getBoard();

    GameState getGameState();

    String getName();

    String getModeDescription();

}
