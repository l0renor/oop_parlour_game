package bunny_hop.logic.rule;

import bunny_hop.logic.BunnyHopGameState;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.CardDeck;
import framework.logic.GameState;
import framework.logic.Rule;
import framework.logic.BasicAccessoryType;

import java.util.List;

public class DrawCardRule implements Rule {

    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        return accessory.getAccessoryType() == BasicAccessoryType.CARD_DECK;
    }

    @Override
    public void setValidActions(GameState state, Board board) {
        resetActions(board);
        BunnyHopGameState bunnyHopGameState = (BunnyHopGameState) state;
        for(Accessory accessory : board.getAccessoriesByLayer().get(2)){
            if(accessory.getAccessoryType() == BasicAccessoryType.CARD_DECK){
                CardDeck cardDeck = (CardDeck) accessory;
                cardDeck.setAction(() -> {
                    int cardValueNumber = cardDeck.pickCard();
                    for (BunnyHopGameState.CardValue cardValue : BunnyHopGameState.CardValue.values()) {
                        if (cardValue.getNumber() == cardValueNumber) {
                            bunnyHopGameState.setCardValue(cardValue);
                            break;
                        }
                    }
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