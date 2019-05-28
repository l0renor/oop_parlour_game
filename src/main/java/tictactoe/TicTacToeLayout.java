package tictactoe;

import framework.configuration.BoardLayout;
import framework.data.Board;

public class TicTacToeLayout implements BoardLayout {

    @Override
    public Board createLayout() {
        Board board = new Board(400, 400, 2, "file:src/resources/tictactoe/background.png", "Tic Tac Toe", "file:src/resources/tictactoe/field_free.png");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.addAccessory(new Field(50 + j*100, 50 + i*100, i, j));
            }
        }

        return board;
    }

}
