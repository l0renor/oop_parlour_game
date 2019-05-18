package bunny_hop;

import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.CardDeck;
import framework.logic.AccessoryType;
import framework.logic.GameState;
import framework.logic.Rule;
import framework.logic.BasicAccessoryType;

import java.util.ArrayList;
import java.util.List;

public class DrawCardRule implements Rule {

    ArrayList<AccessoryType> validAccessoryTypes;

    public DrawCardRule(){
        validAccessoryTypes = new ArrayList<>();
        validAccessoryTypes.add(BasicAccessoryType.CARD_DECK);
    }

    @Override
    public ArrayList<AccessoryType> getValidAccessoryTypes() {
        return validAccessoryTypes;
    }

    @Override
    public void setValidActions(GameState state, Board board) {
        resetActions(board);
        for(Accessory accessory : board.getAccessoriesByLayer().get(2)){
            if(accessory.getAccessoryType() == BasicAccessoryType.CARD_DECK){
                CardDeck cardDeck = (CardDeck) accessory;
                cardDeck.setAction(() -> {
                    cardDeck.pickCard();
                });
            }
        }

    }

    private void resetActions(Board board){
        for (final List<Accessory> layer : board.getAccessoriesByLayer()) {
            for (Accessory accessory : layer) {
                accessory.setAction(() -> {});
            }
        }
    }
}