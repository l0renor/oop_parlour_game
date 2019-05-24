package ludo.configuration;

import framework.configuration.Configuration;
import framework.configuration.GameMode;
import ludo.configuration.four_players.FourPlayerLudoGameMode;

import java.util.ArrayList;

public class LudoConfiguration extends Configuration {
    @Override
    public void configure() {
        ArrayList<GameMode> gameModes = new ArrayList<>();
        gameModes.add(new FourPlayerLudoGameMode());
        setGameModes(gameModes);
        setStartScreenbackground("file:src/resources/bunny_hop/start_screen_background.png");
    }
}
