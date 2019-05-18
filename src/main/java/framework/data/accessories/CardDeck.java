package framework.data.accessories;

import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

import java.util.Random;

public class CardDeck extends Accessory {

    private String pathToBackImage;
    private String[] pathToFrontImage;
    private int numCards;
    private boolean hidden;
    Random randGen;

    public CardDeck(int sizeX, int sizeY, int posX, int posY, int layer, String[] pathToFrontImage, String pathToBackImage) {
        super(sizeX, sizeY, posX, posY, layer, pathToBackImage);
        this.pathToBackImage = pathToBackImage;
        this.pathToFrontImage = pathToFrontImage;
        this.numCards = pathToFrontImage.length;
        hidden = true;
        shuffleCards();
        //this.setAction(accessory -> pickCard());
        Random randGen = new Random();
    }

    /**
     * Shuffles the card deck before the game starts
     */
    private void shuffleCards() {
        for (int i = 0; i < numCards; i++) {
            int randNum = randGen.nextInt(numCards);
            String temp = pathToFrontImage[i];
            pathToFrontImage[i] = pathToFrontImage[randNum];
            pathToFrontImage[randNum] = temp;
        }
    }

    /**
     * If the user clicks on the card deck and the card on top is facing down, it shows the card.
     * Otherwise it will take out the card on top.
     */
    private void pickCard() {
        if (hidden) {
            this.setPathToImage(pathToFrontImage[numCards - 1]);
            hidden = false;
        } else {
            this.setPathToImage(pathToBackImage);
            numCards--;
            hidden = true;
        }
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BasicAccessoryType.CARD_DECK;
    }
}
