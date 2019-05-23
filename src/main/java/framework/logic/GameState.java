package framework.logic;

/**
 * Interface to save a game's current state in.
 */
public interface GameState {

    /**
     * Returns the currently active Player.
     * @return Object of type player, can be specialised subclass.
     */
    Player getActivePlayer();

    /**
     * Saves the given player as currently active one.
     * @param activePlayer Object of type player, can be specialised subclass.
     */
    void setActivePlayer(Player activePlayer);

}
