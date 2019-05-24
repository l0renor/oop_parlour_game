package framework.data.accessories;

import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

public class CardDeck extends Accessory {

    private String pathToBackImage;
    private String[] pathToFrontImage;
    private Stack<Integer> cardOrder = new Stack<>();
    private boolean hidden;

    public CardDeck(int width, int height, int posX, int posY, int layer, int numberOfCards, String[] pathToFrontImage, String pathToBackImage) {
        super(width, height, posX, posY, layer, pathToBackImage);
        this.pathToBackImage = pathToBackImage;
        this.pathToFrontImage = pathToFrontImage;
        this.hidden = true;
        for (int i = 0; i < numberOfCards; i++) {
            cardOrder.add(i % (pathToFrontImage.length - 1));
        }
        Collections.shuffle(cardOrder);
    }

    /**
     * If the user clicks on the card deck and the card on top is facing down, it shows the card.
     * Otherwise it will take out the card on top.
     */
    public int pickCard() {
        if (hidden) {
            hidden = false;
            int cardValue = cardOrder.pop();
            this.setPathToImage(pathToFrontImage[cardValue]);
            return cardValue;
        } else {
            hidden = true;
            this.setPathToImage(pathToBackImage);
            return -1;
        }
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BasicAccessoryType.CARD_DECK;
    }

}
