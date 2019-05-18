package framework.configuration;

import framework.data.Board;
import framework.logic.GameMode;

import java.util.ArrayList;

public abstract class Configuration {

    private ArrayList<GameMode> gameModes;
    private String StartScreenbackground;



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
    public String getStartScreenbackground() { return StartScreenbackground; }
    public void setStartScreenbackground(String startScreenbackground) { StartScreenbackground = startScreenbackground; }

}
