package bunny_hop;

import framework.logic.GameState;
import framework.logic.Player;

public class BunnyGameState implements GameState {

    private Player activePlayer;
    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

}
