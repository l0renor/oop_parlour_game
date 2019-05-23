package framework.logic;

import framework.data.Board;

import java.util.ArrayList;

/**
 * Interface to specify one game mode (strategy pattern)
 */
public interface GameMode {

    /**
     * Returns a list of Players for this GameMode.
     *
     * @return ArrayList of type player.
     */
    ArrayList<Player> getPlayers();

    /**
     * Returns a list with all rules, each corresponding to one action in one turn.
     *
     * @return ArrayList of type Rule.
     */
    ArrayList<Rule> getRules();

    /**
     * Returns the already configured board with layout for this GameMode.
     *
     * @return Fully built board (Initialisation should be directed to implementation of BoardLayout).
     */
    Board getBoard();

    /**
     * Returns the GameState tailored to this Game.
     *
     * @return An object implementing the GameState interface.
     */
    GameState getGameState();

    /**
     * Returns this GameModes individual name.
     *
     * @return Name as a string value.
     */
    String getName();

}
