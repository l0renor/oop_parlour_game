package framework.configuration;

import framework.data.Board;
import framework.logic.GameMode;

import java.util.ArrayList;

public abstract class Configuration {
    private Board startBoard;
    private ArrayList<GameMode> gameModes;



    /**
     * This method should set the startBoard by choosing a layout strategy.
     */
    public abstract void configure();

    public ArrayList<GameMode> getGameModes() {
        return gameModes;
    }
    public void setGameModes(ArrayList<GameMode> gameModes) {
        this.gameModes = gameModes;
    }

    public Board getStartBoard() {
        return startBoard;
    }

    public void setStartBoard(Board startBoard) {
        this.startBoard = startBoard;
    }
}
