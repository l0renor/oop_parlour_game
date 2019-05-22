package bunny_hop;

import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.data.accessories.CardDeck;
import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;
import framework.logic.GameState;
import framework.logic.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardMoveRule implements Rule {

    private ArrayList<AccessoryType> validAccessoryTypes;
    private Random random;

    public CardMoveRule() {
        validAccessoryTypes = new ArrayList<>();
        validAccessoryTypes.add(BunnyGameAccessoryType.BUNNY);
        validAccessoryTypes.add(BunnyGameAccessoryType.CARROT);
        random = new Random();
    }

    @Override
    public ArrayList<AccessoryType> getValidAccessoryTypes() {
        return validAccessoryTypes;
    }

    @Override
    public void setValidActions(GameState state, Board board) {
        resetActions(board);

        BunnyGameState gameState = (BunnyGameState) state;

        if (gameState.getCardValue() == BunnyGameState.CardValue.CARROT) {
            for (Accessory accessory : board.getAccessoriesByLayer().get(1)) {
                if (accessory.getAccessoryType() == BunnyGameAccessoryType.CARROT) {
                    accessory.setAction(() -> {
                        for (Accessory accLayer1 : board.getAccessoriesByLayer().get(1)) {
                            if (accLayer1.getAccessoryType() == BunnyGameAccessoryType.FIELD) {
                                Field field = (Field) accLayer1;
                                if (field.isOpen()) field.setOpen(false);
                            }
                        }

                        int firstHole = random.nextInt(board.getAccessoriesByLayer().get(1).size() - 1) + 1;
                        int secHole = random.nextInt(board.getAccessoriesByLayer().get(1).size() - 1) + 1;
                        Field firstField = (Field) board.getAccessoriesByLayer().get(1).get(firstHole);
                        firstField.setOpen(true);
                        Field secField = (Field) board.getAccessoriesByLayer().get(1).get(secHole);
                        secField.setOpen(true);

                        for (Accessory accLayer2 : board.getAccessoriesByLayer().get(2)) {
                            if (accLayer2.getAccessoryType() == BunnyGameAccessoryType.BUNNY) {
                                Bunny bunny = (Bunny) accLayer2;
                                if (bunny.getFieldNumber() == firstHole || bunny.getFieldNumber() == secHole) {
                                    bunny.resetToStartPos();
                                }
                            }
                        }
                    });
                }
            }

        } else {
            for (Accessory accessory : board.getAccessoriesByLayer().get(2)) {
                if (accessory.getAccessoryType() == BunnyGameAccessoryType.BUNNY
                        && accessory.getPlayer() == gameState.getActivePlayer()) {
                    accessory.setAction(() -> {
                        Bunny bunny = (Bunny) accessory;
                        bunny.setFieldNumber(bunny.getFieldNumber() + gameState.getCardValue().getNumber());
                        bunny.setPosX(board.getAccessoriesByLayer().get(1).get(bunny.getFieldNumber()).getPosX());
                        bunny.setPosY(board.getAccessoriesByLayer().get(1).get(bunny.getFieldNumber()).getPosY());
                    });
                }
            }

        }

        for(Accessory accessory : board.getAccessoriesByLayer().get(1)){
            if(accessory.getAccessoryType() == BasicAccessoryType.CARD_DECK){
                CardDeck cardDeck = (CardDeck) accessory;
                cardDeck.pickCard();
            }
        }

    }

    private void resetActions(Board board) {
        for (final List<Accessory> layer : board.getAccessoriesByLayer()) {
            for (Accessory accessory : layer) {
                accessory.setAction(() -> {
                });
            }
        }
    }
}
