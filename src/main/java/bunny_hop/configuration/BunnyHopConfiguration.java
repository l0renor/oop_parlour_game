package bunny_hop.configuration;

import bunny_hop.configuration.fourPlayers.fourPlayerGameMode;
import framework.configuration.Configuration;
import framework.configuration.GameMode;

import java.util.ArrayList;

public class BunnyHopConfiguration extends Configuration {
    public void configure() {

        ArrayList<GameMode> gameModes = new ArrayList<>();
        gameModes.add(new fourPlayerGameMode());
        setGameModes(gameModes);
        setStartScreenbackground("file:src/resources/bunny_hop/start_screen_background.png");
    }
}
