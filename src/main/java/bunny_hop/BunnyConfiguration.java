package bunny_hop;

import framework.configuration.Configuration;
import framework.data.Board;
import framework.logic.GameMode;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;

import java.util.ArrayList;

public class BunnyConfiguration extends Configuration {
    public void configure() {
        //setStartBoard( new BunnyLayout().createLayout());
        ArrayList<GameMode> gameModes = new ArrayList<>();
        gameModes.add(new GameMode() {
            @Override
            public int getNumberOfPlayers() {
                return 0;
            }

            @Override
            public Player constructPlayer() {
                return null;
            }

            @Override
            public ArrayList<Rule> getRules() {
                return null;
            }

            @Override
            public Board getBoard() {
                return new BunnyLayout().createLayout();
            }

            @Override
            public GameState getGameState() {
                return null;
            }

            @Override
            public String getName() {
                return "Gamemode 1";
            }

            @Override
            public String getModeDescription() {
                return "Lorem Ipsum msmfdfh";
            }
        });
        gameModes.add(new GameMode() {
            @Override
            public int getNumberOfPlayers() {
                return 0;
            }

            @Override
            public Player constructPlayer() {
                return null;
            }

            @Override
            public ArrayList<Rule> getRules() {
                return null;
            }

            @Override
            public Board getBoard() {
                return null;
            }

            @Override
            public GameState getGameState() {
                return null;
            }

            @Override
            public String getName() {
                return "Gamemode 2";
            }

            @Override
            public String getModeDescription() {
                return "Lorem Ipsum msmfdfh";
            }
        });
        setGameModes(gameModes);
        setStartScreenbackground("file:src/resources/bunny_hop/start_screen_background.png");
    }
}
