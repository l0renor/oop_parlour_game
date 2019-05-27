package bunny_hop.logic.rule;

import bunny_hop.logic.BunnyHopGameState;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.CardDeck;
import framework.logic.GameState;
import framework.logic.Rule;
import framework.data.BasicAccessoryType;

public class DrawCardRule implements Rule {

    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        return accessory.getAccessoryType() == BasicAccessoryType.CARD_DECK;
    }

    @Override
    public void setValidActions(GameState state, Board board) {
        board.resetAllActions();
        BunnyHopGameState bunnyHopGameState = (BunnyHopGameState) state;
        for (Accessory accessory : board.getAccessories(2, BasicAccessoryType.CARD_DECK)) {
            CardDeck cardDeck = (CardDeck) accessory;
            cardDeck.setAction(() -> {
                playSound("src/resources/bunny_hop/sounds/shuffle.wav");
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