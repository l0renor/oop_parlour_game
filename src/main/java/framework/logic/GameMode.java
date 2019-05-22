package framework.logic;

import framework.data.Board;

import java.util.ArrayList;

/**
 * Interface to specify the game mode (strategy pattern)
 */
public interface GameMode {

    ArrayList<Player> getPlayers();

    /**
     * Returns the list with all ruleset, each corresponding to one Action in a turn.
     *
     * @return ArrayList with Rule.
     */
    ArrayList<Rule> getRules();

    /**
     *
     * @return
     */
    Board getBoard();

    /**
     *
     * @return
     */
    GameState getGameState();

    /**
     *
     * @return
     */
    String getName();


}
