package framework.logic;

import framework.data.Point;
import framework.data.accessories.Accessory;
import framework.graphics.GraphicsEngine;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {


    private GameMode gameMode;
    private GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();
    private final Stage stage;
    private int activeRule;
    private int activePlayer;

    public Game(GameMode gameMode, Stage stage) {
        this.gameMode = gameMode;
        this.stage = stage;
        this.graphicsEngine.addObserver(this);
        activeRule = 0;
        activePlayer = 0;
        gameMode.getBoard().appendToInfoText(String.format("It's %s's turn!", gameMode.getPlayers().get(activePlayer).getName()));
        graphicsEngine.drawBoard(gameMode.getBoard(), stage);


    }



    /**
     * @param player
     */
    private void doTurn(Player player) {
        // Print to screen: String.format("It's %s's turn!", player.getName())
        // Notify player about changes

        // Action handling below
        for (Rule rule : gameMode.getRules()) {
            ArrayList<AccessoryType> validAccessoryTypes = rule.getValidAccessoryTypes();
        }
        //Change of structure after turn actions.
        //TODO, probably use some methods / objects provided by strategy GameMode
    }

    public void update(Observable o, Object arg) {
        //TODO automatic actions just call update game or add to previous action?
        Point point = (Point) arg;
        Accessory clickedAccessory = getAccessoryByPoint(point);
        if (clickedAccessory == null || !gameMode.getRules().get(activeRule).getValidAccessoryTypes().contains(clickedAccessory.getAccessoryType())) {
            return; // no valid accessory was clicked -> Game remains in the same state
        }
        clickedAccessory.doAction();
        updateGame();
    }

    private void updateGame() {
        activeRule = (activeRule + 1) % gameMode.getRules().size();
        if (activeRule == 0) {
            do {
                activePlayer = (activePlayer + 1) % gameMode.getPlayers().size();
            } while (gameMode.getPlayers().get(activePlayer).isOut());
            gameMode.getBoard().appendToInfoText(String.format("It's %s's turn!", gameMode.getPlayers().get(activePlayer).getName()));
        }
        graphicsEngine.drawBoard(gameMode.getBoard(), stage);
    }

    private Accessory getAccessoryByPoint(Point point) {
        for (final List<Accessory> layer : gameMode.getBoard().getAccessoriesByLayer()) {
            for (Accessory accessory : layer) {
                if ((accessory.getPosX() < point.getX() && point.getX() < (accessory.getPosX() + accessory.getWidth()))
                        && (accessory.getPosY() < point.getY() && point.getY() < (accessory.getPosY() + accessory.getHeight()))) {
                    return accessory;
                }
            }
        }
        return null;
    }
}

