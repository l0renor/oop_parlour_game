package framework.logic;

/**
 * Interface to save a game's current state in.
 */
public abstract class GameState {

    private Player activePlayer;


    /**
     * Returns the currently active Player.
     * @return Object of type player, can be specialised subclass.
     */
    public Player getActivePlayer() {
        return activePlayer;
    }


    /**
     * Saves the given player as currently active one.
     * @param activePlayer Object of type player, can be specialised subclass.
     */
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * Tells whether the next rule should be repeated
     * @return whether the next Turn should be repeated(same Player)
     */
    public abstract boolean isTurnRepeated();

    /**
     * Set if  the next rule sould be repeated
     * @param repeated flag if  the next Turn sould be repeated(by the same Player)
     */
    public abstract void setTurnRepeated(boolean repeated);

}
