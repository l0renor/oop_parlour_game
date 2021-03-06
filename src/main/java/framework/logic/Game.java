package framework.logic;

import framework.configuration.GameMode;
import framework.data.Point;
import framework.data.accessories.Accessory;
import framework.graphics.GraphicsEngine;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 *
 */
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
        gameMode.getRules().get(activeRule).setValidActions(gameMode.getGameState(), gameMode.getBoard());
        gameMode.getGameState().setActivePlayer(gameMode.getPlayers().get(0));
    }

    /**
     * Gets notified when a change occurs on the Observable class and updates the game board
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        Point point = (Point) arg;
        Accessory clickedAccessory = getAccessoryByPoint(point);
        if (clickedAccessory == null || !gameMode.getRules().get(activeRule).isAccessoryValid(gameMode.getGameState(), clickedAccessory)) {
            return; // no valid accessory was clicked -> Game remains in the same state
        }
        clickedAccessory.doAction();
        updateGame();
    }


    private void updateGame() {
        if(gameMode.isFinished()){
            gameMode.getBoard().setInfoText(gameMode.getGameState().getScore());
            graphicsEngine.drawBoard(gameMode.getBoard(), stage);
            return;
        }
        if (gameMode.getGameState().isTurnRepeated()) {
            gameMode.getGameState().setTurnRepeated(false);
        } else {
            activeRule = (activeRule + 1) % gameMode.getRules().size();
            if (activeRule == 0) {
                // New players turn starts
                do {
                    activePlayer = (activePlayer + 1) % gameMode.getPlayers().size();
                } while (gameMode.getPlayers().get(activePlayer).isOut());
                gameMode.getGameState().setActivePlayer(gameMode.getPlayers().get(activePlayer));
                gameMode.getBoard().setInfoText(String.format("It's %s's turn!", gameMode.getPlayers().get(activePlayer).getName()));
            }
        }
        graphicsEngine.drawBoard(gameMode.getBoard(), stage);
        gameMode.getRules().get(activeRule).setValidActions(gameMode.getGameState(), gameMode.getBoard());
    }

    /**
     * Finds what accessory was clicked in given point
     * @param point
     * @return Accessory in the point given
     */
    private Accessory getAccessoryByPoint(Point point) {
        for (int i = gameMode.getBoard().getNumberOfLayers() ; i > 0; i--) {
            for (Accessory accessory : gameMode.getBoard().getAccessories(i)) {
                if ((accessory.getPosX() < point.getX() && point.getX() < (accessory.getPosX() + accessory.getWidth()))
                        && (accessory.getPosY() < point.getY() && point.getY() < (accessory.getPosY() + accessory.getHeight()))) {
                    return accessory;
                }
            }
        }
        return null;
    }
}

