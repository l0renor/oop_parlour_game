package framework.data.accessories;

public class SixSideDice extends Dice {

    public SixSideDice(int sizeX, int sizeY, int posX, int posY, int layer) {
        super(sizeX, sizeY, posX, posY, layer, new String[] {"file:src/resources/dice/one.jpg", "file:src/resources/dice/two.jpg", "file:src/resources/dice/three.jpg", "file:src/resources/dice/four.jpg", "file:src/resources/dice/five.jpg", "file:src/resources/dice/six.jpg"});
    }

}
