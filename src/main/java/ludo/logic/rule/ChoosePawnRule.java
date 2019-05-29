package ludo.logic.rule;

import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.logic.GameState;
import framework.logic.Rule;
import ludo.accessories.Pawn;
import ludo.logic.LudoAccessoryType;
import ludo.logic.LudoGameState;

public class ChoosePawnRule implements Rule {

    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        if(accessory.getAccessoryType() == LudoAccessoryType.PAWN && accessory.getPlayer() == gameState.getActivePlayer())
            return true;
        else return false;
    }

    @Override
    public void setValidActions(GameState gameState, Board board) {
        board.resetAllActions();
        LudoGameState ludoGameState = (LudoGameState) gameState;
        boolean movePossible = false;
        for(Accessory acc : board.getAccessories(2, LudoAccessoryType.PAWN, gameState.getActivePlayer())){
            Pawn pawn = (Pawn) acc;

            if(pawn.getFieldNumber() != -1 || (pawn.getFieldNumber() == -1 && ludoGameState.getDiceValue() == 6)){
                pawn.setAction(() -> pawn.move(ludoGameState.getDiceValue()));
            }
        }


    }
}
