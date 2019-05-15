package framework.logic;

import framework.data.Board;
import framework.graphics.GraphicsEngine;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game implements Runnable, Observer {

    private ArrayList<Player> players = new ArrayList<Player>();
    private GameMode gameMode;
    private int turnCounter = 0;
    private GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        this.graphicsEngine.addObserver(this);
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

        // Action handling below
        for (RuleSet ruleSet : gameMode.getRuleSets()) {
            ArrayList<AccessoryType> validAccessoryTypes = ruleSet.getValidAccessoryTypes();
        }
        //Change of structure after turn actions.
        //TODO, probably use some methods / objects provided by strategy GameMode
    }

    public void update(Observable o, Object arg) {

    }
}
