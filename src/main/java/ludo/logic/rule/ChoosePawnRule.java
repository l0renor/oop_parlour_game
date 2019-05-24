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
        return false;
    }

    @Override
    public void setValidActions(GameState gameState, Board board) {
        LudoGameState ludoGameState = (LudoGameState) gameState;

        for(Accessory acc : board.getAccessories(2, LudoAccessoryType.PAWN, gameState.getActivePlayer())){
            Pawn pawn = (Pawn) acc;
            pawn.setAction(() -> pawn.move(ludoGameState.getDiceValue()));
        }
    }
}
