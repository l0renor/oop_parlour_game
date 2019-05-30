package ludo.logic;

import framework.logic.GameState;

public class LudoGameState extends GameState {

    private int diceValue;
    private boolean isTurnRepeated;

    @Override
    public boolean isTurnRepeated() {
        return isTurnRepeated;
    }

    @Override
    public void setTurnRepeated(boolean repeated) {
        isTurnRepeated = repeated;

    }

    @Override
    public String getScore() {
        return null;
    }

    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }

    public int getDiceValue(){
        return diceValue;
    }
}
