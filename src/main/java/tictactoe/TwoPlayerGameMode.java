package tictactoe;

import framework.configuration.GameMode;
import framework.data.Board;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;

import java.util.ArrayList;
import java.util.Collections;

public class TwoPlayerGameMode implements GameMode {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private Board board = new TicTacToeLayout().createLayout();
    private TicTacToeGameState gameState = new TicTacToeGameState();

    public TwoPlayerGameMode() {
        players.add(new Player("X"));
        players.add(new Player("O"));
        Collections.shuffle(players);
        rules.add(new SetMarkRule());
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public ArrayList<Rule> getRules() {
        return rules;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public String getName() {
        return "Two Players";
    }

    @Override
    public boolean isFinished() {
        if (gameState.isOver()) {
            board.resetAllActions();
            return true;
        } else {
            return false;
        }
    }
}
