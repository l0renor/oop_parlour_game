package tictactoe;

import framework.configuration.Configuration;
import framework.configuration.GameMode;

import java.util.ArrayList;

public class TicTacToeConfiguration extends Configuration {

    @Override
    public void configure() {
        ArrayList<GameMode> gameModes = new ArrayList<>();
        gameModes.add(new TwoPlayerGameMode());
        setGameModes(gameModes);
        setStartScreenbackground("file:src/resources/tictactoe/tictactoestart.png");
    }

}
