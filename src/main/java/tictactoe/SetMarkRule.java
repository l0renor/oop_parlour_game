package tictactoe;

import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.logic.GameState;
import framework.logic.Rule;

public class SetMarkRule implements Rule {

    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        Field field = (Field) accessory;
        TicTacToeGameState ticTacToeGameState = (TicTacToeGameState) gameState;
        return ticTacToeGameState.isFieldFree(field);
    }

    @Override
    public void setValidActions(GameState gameState, Board board) {
        TicTacToeGameState ticTacToeGameState = (TicTacToeGameState) gameState;
        for (Accessory accessory : board.getAccessories(1)) {
            Field field = (Field) accessory;
            field.setAction(() -> ticTacToeGameState.occupyField(field, gameState.getActivePlayer().getName().charAt(0)));
        }
    }
}
