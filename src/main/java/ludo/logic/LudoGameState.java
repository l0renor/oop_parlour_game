package ludo.logic;

import framework.logic.GameState;
import framework.logic.Player;

public class LudoGameState implements GameState {

    private Player activePlayer;
    private int diceValue;
    private boolean isTurnRepeated;

    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void setActivePlayer(Player activePlayer) {
        activePlayer = activePlayer;
    }

    @Override
    public boolean isTurnRepeated() {
        return isTurnRepeated;
    }

    @Override
    public void setTurnRepeated(boolean repeated) {
        isTurnRepeated = repeated;

    }

    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }

    public int getDiceValue(){
        return diceValue;
    }
}
