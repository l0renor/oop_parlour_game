package bunny_hop.logic.rule;

import bunny_hop.accessories.Field;
import bunny_hop.accessories.Bunny;
import bunny_hop.logic.BunnyHopAccessoryType;
import bunny_hop.logic.BunnyHopGameState;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.CardDeck;
import framework.logic.BasicAccessoryType;
import framework.logic.GameState;
import framework.logic.Rule;

import java.util.List;
import java.util.Random;

public class CardMoveRule implements Rule {

    private Random random;

    public CardMoveRule() {
        random = new Random();
    }

    @Override
    public boolean isAccessoryValid(GameState gameState, Accessory accessory) {
        BunnyHopGameState bunnyHopGameState = (BunnyHopGameState) gameState;
        if (bunnyHopGameState.getCardValue() == BunnyHopGameState.CardValue.CARROT && accessory.getAccessoryType() == BunnyHopAccessoryType.CARROT) {
            return true;
        } else if (bunnyHopGameState.getCardValue() != BunnyHopGameState.CardValue.CARROT && accessory.getAccessoryType() == BunnyHopAccessoryType.BUNNY && accessory.getPlayer() == bunnyHopGameState.getActivePlayer()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValidActions(GameState gameState, Board board) {
        board.resetAllActions();
        BunnyHopGameState bunnyHopGameState = (BunnyHopGameState) gameState;

        for (Accessory accessory : board.getAccessories(1, BunnyHopAccessoryType.CARROT)) {
            accessory.setAction(() -> {
                for (Accessory accessoryLayer1 : board.getAccessories(1, BunnyHopAccessoryType.FIELD)) {
                    Field field = (Field) accessoryLayer1;
                    field.setOpen(false);
                }
                int firstHole = random.nextInt(board.getAccessories(1).size() - 1) + 1;
                int secHole = random.nextInt(board.getAccessories(1).size() - 1) + 1;
                bunnyHopGameState.setHoles(new int []{firstHole,secHole});
                Field firstField = (Field) board.getAccessories(1).get(firstHole);
                firstField.setOpen(true);
                Field secField = (Field) board.getAccessories(1).get(secHole);
                secField.setOpen(true);
                bunnyHopGameState.freeField((Field) board.getAccessories(1).get(firstHole));
                bunnyHopGameState.freeField((Field) board.getAccessories(1).get(secHole));
                for (Accessory accessoryLayer2 : board.getAccessories(2, BunnyHopAccessoryType.BUNNY)) {
                    Bunny bunny = (Bunny) accessoryLayer2;
                    if (bunny.getFieldNumber() == firstHole || bunny.getFieldNumber() == secHole) {
                        bunny.resetToStartPos();
                    }
                }
            });
        }

        for (Accessory accessory : board.getAccessories(2, BunnyHopAccessoryType.BUNNY, gameState.getActivePlayer())) {
            accessory.setAction(() -> {
                Bunny bunny = (Bunny) accessory;
                int oldFieldNumber = bunny.getFieldNumber();
                if (oldFieldNumber != 0) {
                    bunnyHopGameState.freeField((Field) board.getAccessories(1).get(oldFieldNumber));
                }
                int newFieldNumber = oldFieldNumber + bunnyHopGameState.getCardValue().getNumber();
                while (!bunnyHopGameState.occupyField((Field) board.getAccessories(1).get(newFieldNumber))) {
                    newFieldNumber++;
                }
                if(bunnyHopGameState.isHole(newFieldNumber)){
                    bunny.resetToStartPos();
                    bunny.setFieldNumber(0);
                    bunnyHopGameState.freeField((Field) board.getAccessories(1).get(newFieldNumber));
                }else {
                    bunny.setPosX(board.getAccessories(1).get(newFieldNumber).getPosX());
                    bunny.setPosY(board.getAccessories(1).get(newFieldNumber).getPosY());
                    bunny.setFieldNumber(newFieldNumber);
                }

            });
        }

        for (Accessory accessory : board.getAccessories(2, BasicAccessoryType.CARD_DECK)) {
            CardDeck cardDeck = (CardDeck) accessory;
            cardDeck.pickCard();
        }
    }
}
