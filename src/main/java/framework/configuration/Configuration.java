package framework.configuration;

import java.util.ArrayList;

public abstract class Configuration {

    private ArrayList<GameMode> gameModes;
    private String startScreenbackground;



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
    public String getStartScreenbackground() { return startScreenbackground; }
    public void setStartScreenbackground(String startScreenbackground) { this.startScreenbackground = startScreenbackground; }

}
