package framework.data.accessories;

import framework.data.accessories.Accessory;

import java.util.Random;

public class Dice extends Accessory {

    int numSides;
    String[] pathToSides;

    public Dice(int sizeX, int sizeY, int posX, int posY, int layer, String[] pathToSides) {
        super(sizeX, sizeY, posX, posY, layer, pathToSides[0]);
        this.numSides = pathToSides.length;
        this.pathToSides = pathToSides;
    }

    /**
     * It will roll the dice and change the image according to the side that should be facing up
     */
    public void onClick() {
        int side = this.roll();
        this.setPathToImage(pathToSides[side]);
    }

    /**
     * Simulates rolling the dice
     * @return random generated number
     */
    public int roll(){
        return (new Random().nextInt(numSides)) + 1;
    }

}