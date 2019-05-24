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

    /**
     * Tells whether the next rule should be repeated
     * @return whether the next Turn should be repeated(same Player)
     */
    boolean isTurnRepeated();

    /**
     * Set if  the next rule sould be repeated
     * @param repeated flag if  the next Turn sould be repeated(by the same Player)
     */
    void setTurnRepeated(boolean repeated);

}
