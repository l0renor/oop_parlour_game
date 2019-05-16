package framework.logic;

import framework.data.Board;
import framework.data.Point;
import framework.data.accessories.Accessory;
import framework.graphics.GraphicsEngine;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game implements Runnable, Observer {

    private ArrayList<Player> players = new ArrayList<Player>();
    private GameMode gameMode;
    private int turnCounter = 0;
    private GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();
    private final Stage stage;
    private Rule activeRule;

    public Game(GameMode gameMode, Stage stage) {
        this.gameMode = gameMode;
        this.stage = stage;
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
     * @param player
     */
    private void doTurn(Player player) {
        // Print to screen: String.format("It's %s's turn!", player.getName())
        // Notify player about changes

        // Action handling below
        for (Rule rule : gameMode.getRuleSets()) {
            ArrayList<AccessoryType> validAccessoryTypes = rule.getValidAccessoryTypes();
        }
        //Change of structure after turn actions.
        //TODO, probably use some methods / objects provided by strategy GameMode
    }

    public void update(Observable o, Object arg) {
        //TODO automatic actions
        Point point = (Point) arg;
        Accessory clickedAccessory = getAccessoryByPoint(point);
        if (clickedAccessory == null || !activeRule.getValidAccessoryTypes().contains(clickedAccessory.getAccessoryType())) {
            return; // no valid accessory was clicked -> Game remains in the same state
        }
        clickedAccessory.doAction();


    }

    private void updateGame() {
        graphicsEngine.drawBoard(gameMode.getBoard(), stage);
    }

    private Accessory getAccessoryByPoint(Point point) {
        for (final List<Accessory> currentLayer : gameMode.getBoard().getAccessoriesByLayer()) {
            for (Accessory accessory : currentLayer) {
                //IF accessory was clicked call onclick
                if ((accessory.getPosX() < point.getX() && point.getX() < (accessory.getPosX() + accessory.getWidth()))
                        && (accessory.getPosY() < point.getY() && point.getY() < (accessory.getPosY() + accessory.getHeight()))) {
                    return accessory;
                }
            }
        }
        return null;
    }
}

