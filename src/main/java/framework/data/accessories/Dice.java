package framework.data.accessories;

import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

import java.util.Random;

public class Dice extends Accessory {

    private int numSides;
    private int currentValue;
    private String[] pathToSides;

    public Dice(int sizeX, int sizeY, int posX, int posY, int layer, String[] pathToSides) {
        super(sizeX, sizeY, posX, posY, layer, pathToSides[0]);
        this.numSides = pathToSides.length;
        this.pathToSides = pathToSides;
    }

    /**
     * Simulates rolling the dice
     */
    private void roll(){
        currentValue = (new Random().nextInt(numSides)) + 1;
        this.setPathToImage(pathToSides[currentValue-1]);
    }

    /**
     * @return current value of the dice
     */
    public int getCurrentValue() {
        return currentValue;
    }


    /**
     * @return type of the accessory
     */
    @Override
    public AccessoryType getAccessoryType() {
        return BasicAccessoryType.DICE;
    }
}