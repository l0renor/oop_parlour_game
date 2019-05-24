package bunny_hop.configuration.fourPlayers;

import bunny_hop.accessories.Bunny;
import bunny_hop.logic.BunnyHopAccessoryType;
import bunny_hop.logic.BunnyHopGameState;
import bunny_hop.logic.rule.CardMoveRule;
import bunny_hop.logic.rule.DrawCardRule;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.configuration.GameMode;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;

import java.util.ArrayList;

public class fourPlayerGameMode implements GameMode {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private Board board = new fourPlayerLayout().createLayout();
    private GameState gameState = new BunnyHopGameState();


    public fourPlayerGameMode() {
        players.add(new Player("Leon"));
        players.add(new Player("Fabi"));
        players.add(new Player("Marina"));
        players.add(new Player("Waagna"));
        rules.add(new DrawCardRule());
        rules.add(new CardMoveRule());
        gameState.setActivePlayer(players.get(0));
        assignBunnyToPlayer(Bunny.BunnyColor.PINK,players.get(0));
        assignBunnyToPlayer(Bunny.BunnyColor.RED,players.get(1));
        assignBunnyToPlayer(Bunny.BunnyColor.PURPLE,players.get(2));
        assignBunnyToPlayer(Bunny.BunnyColor.CYAN,players.get(3));
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
        return "Bunny Hop | 4 Players";
    }

    private void assignBunnyToPlayer(Bunny.BunnyColor type, Player player) {
        for(Accessory accessory : board.getAccessoriesByLayer().get(2)){//bunny are always on layer 2
            if(accessory.getAccessoryType() == BunnyHopAccessoryType.BUNNY){//sehr krass
                Bunny bunny = (Bunny) accessory;
                if (bunny.getBunnyColor() == type){
                    bunny.setPlayer(player);
                }
            }
        }
    }


}
