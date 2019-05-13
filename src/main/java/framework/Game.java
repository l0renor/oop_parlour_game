package framework;

import java.util.ArrayList;

public class Game implements Runnable {

    private ArrayList<Player> players = new ArrayList<Player>();
    private GameMode gameMode;
    private int turnCounter = 0;
    //TODO add Board....

    /**
     *
     * @param gameMode
     */
    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        addPlayers();
    }

    /**
     * Adds all the players by letting the gameMode construct them.
     */
    private void addPlayers() {
        for (int i = 0; i < gameMode.getNumberOfPlayers(); i++) {
            players.add(gameMode.constructPlayer());
        }
    }

    /**
     * Runs the game itself.
     */
    public void run() {
        while (true) {
            Player activePlayer = players.get(turnCounter % gameMode.getNumberOfPlayers());
            doTurn(activePlayer);
            turnCounter++;
        }
    }

    /**
     *
     * @param player
     */
    private void doTurn(Player player) {
        // Print to screen: String.format("It's %s's turn!", player.getName())
        // Notify player about changes
        for (RuleSet ruleSet : gameMode.getRuleSets()) {
            // Action handling in here, ruleSet is given already
        }
        //Change of structure after turn actions.
        //TODO, probably use some methods / objects provided by strategy GameMode
    }
}
