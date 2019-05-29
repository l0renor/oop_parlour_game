package framework.configuration;

import java.util.List;

/**
 *
 */
public abstract class Configuration {

    private List<GameMode> gameModes;
    private String startScreenbackground;

    /**
     * This method should set the startBoard by choosing a layout strategy.
     */
    public abstract void configure();

    /**
     * @return list of the gameModes
     */
    public List<GameMode> getGameModes() {
        return gameModes;
    }

    /**
     * @param gameModes
     */
    public void setGameModes(List<GameMode> gameModes) {
        this.gameModes = gameModes;
    }

    /**
     * @return String that indicates the path to the start screen
     */
    public String getStartScreenbackground() {
        return startScreenbackground;
    }

    /**
     * @param startScreenbackground
     */
    public void setStartScreenbackground(String startScreenbackground) {
        this.startScreenbackground = startScreenbackground;
    }

}
