package ludo.logic;

import framework.logic.GameState;
import framework.logic.Player;

public class LudoGameState implements GameState {

    private Player activePlayer;
    private int diceValue;

    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void setActivePlayer(Player activePlayer) {
        activePlayer = activePlayer;
    }

    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }

    public int getDiceValue(){
        return diceValue;
    }
}
