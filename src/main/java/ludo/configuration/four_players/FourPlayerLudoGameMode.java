package ludo.configuration.four_players;

import framework.configuration.GameMode;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;
import ludo.accessories.Pawn;
import ludo.logic.LudoAccessoryType;
import ludo.logic.LudoGameState;
import ludo.logic.rule.ChoosePawnRule;
import ludo.logic.rule.RollDiceRule;

import java.util.ArrayList;

public class FourPlayerLudoGameMode implements GameMode {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private Board board = new FourPlayerLudoLayout().createLayout();
    private GameState gameState = new LudoGameState();

    public FourPlayerLudoGameMode() {
        players.add(new Player("Green"));
        players.add(new Player("Red"));
        players.add(new Player("Blue"));
        players.add(new Player("Yellow"));
        rules.add(new RollDiceRule());
        rules.add(new ChoosePawnRule());
        assignPawnToPlayer(Pawn.PawnColor.GREEN,players.get(0));
        assignPawnToPlayer(Pawn.PawnColor.RED,players.get(1));
        assignPawnToPlayer(Pawn.PawnColor.BLUE,players.get(2));
        assignPawnToPlayer(Pawn.PawnColor.YELLOW,players.get(3));

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
        return "Ludo";
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    private void assignPawnToPlayer(Pawn.PawnColor pawnColor, Player player) {
        for (Accessory accessory : board.getAccessories(2, LudoAccessoryType.PAWN)) {
            Pawn pawn = (Pawn) accessory;
            if (pawn.getPawnColor() == pawnColor) {
                pawn.setPlayer(player);
            }
        }
    }
}
