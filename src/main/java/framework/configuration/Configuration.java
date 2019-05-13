package framework.configuration;

import framework.data.Board;

public abstract class Configuration {
    private Board board;

    /**
     * This method should set the board by choosing a layout strategy.
     */
    public abstract void configureBoard();

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
