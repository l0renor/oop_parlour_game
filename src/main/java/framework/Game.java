package framework;

import java.util.ArrayList;

public class Game implements Runnable {

    private ArrayList<Player> players = new ArrayList<Player>();
    private GameMode gameMode;
    private int turnCounter = 0;
    //TODO add Board....

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        addPlayers();
    }

    private void addPlayers() {
        for (int i = 0; i < gameMode.getNumberOfPlayers(); i++) {
            players.add(gameMode.constructPlayer());
        }
    }

    public void run() {
        while (true) {
            Player activePlayer = players.get(turnCounter % gameMode.getNumberOfPlayers());
            doTurn(activePlayer);
            turnCounter++;
        }
    }

    public void doTurn(Player player) {
        //TODO, probably use some methods / objects provided by strategy GameMode
    }
}
