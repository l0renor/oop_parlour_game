package framework.logic;

public interface GameState {

    /**
     *
     * @return
     */
    Player getActivePlayer();

    /**
     *
     * @param activePlayer
     */
    void setActivePlayer(Player activePlayer);
}
