package ludo.logic.rule;

import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.SixSideDice;
import framework.logic.BasicAccessoryType;
import framework.logic.GameState;
import framework.logic.Rule;
import ludo.logic.LudoGameState;

public class RollDiceRule implements Rule {


    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        return accessory.getAccessoryType() == BasicAccessoryType.DICE;
    }

    @Override
    public void setValidActions(GameState gameState, Board board) {
        LudoGameState ludoGameState = (LudoGameState) gameState;

        for(Accessory acc : board.getAccessories(1, BasicAccessoryType.DICE)){
            SixSideDice dice = (SixSideDice) acc;
            dice.setAction(() -> {
                dice.roll();
                ludoGameState.setDiceValue(dice.getCurrentValue());
            });
        }
    }
}
