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
     * Simulates rolling the dice
     * @return random generated number
     */
    public int roll(){
        int side = (new Random().nextInt(numSides)) + 1;
        this.setPathToImage(pathToSides[side-1]);
        return side;
    }

}