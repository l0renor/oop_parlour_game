package framework.logic;

public interface GameState {
    Player getActivePlayer();
    void setActivePlayer(Player activePlayer);
}
