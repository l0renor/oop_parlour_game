package framework.logic;

/**
 * Interface to save a game's current state in.
 */
public abstract class GameState {

    private Player activePlayer;

    /**
     * Returns the currently active Player.
     *
     * @return Object of type player, can be specialised subclass.
     */
    public Player getActivePlayer() {
        return activePlayer;
    }


    /**
     * Saves the given player as currently active one.
     *
     * @param activePlayer Object of type player, can be specialised subclass.
     */
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * Tells whether the current rule should be repeated
     *
     * @return boolean representing the repetition.
     */
    public abstract boolean isTurnRepeated();

    /**
     * Set repetition of the current rule.
     *
     * @param repeated boolean indicating if the current action should be repeated.
     */
    public abstract void setTurnRepeated(boolean repeated);

    /**
     * Indicates whether the game ended.
     * @return whether the game ended
     */

    /**
     * Only called if the game is finished to get the score as a String.
     * This text will be displayed in the text box below the game.
     * @return the score as a string
     */
    public abstract String getScore();


}
