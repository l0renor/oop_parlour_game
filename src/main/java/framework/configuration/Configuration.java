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

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public void setGameModes(List<GameMode> gameModes) {
        this.gameModes = gameModes;
    }

    public String getStartScreenbackground() {
        return startScreenbackground;
    }

    public void setStartScreenbackground(String startScreenbackground) {
        this.startScreenbackground = startScreenbackground;
    }

}
