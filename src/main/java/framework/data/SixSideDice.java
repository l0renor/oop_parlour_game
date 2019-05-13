package framework.data;

public class SixSideDice extends Dice {

    public SixSideDice(int sizeX, int sizeY, int posX, int posY, int layer) {
        super(sizeX, sizeY, posX, posY, layer, new String[] {"src/resources/dice/one.jpg", "src/resources/dice/two.jpg", "src/resources/dice/three.jpg", "src/resources/dice/four.jpg", "src/resources/dice/five.jpg", "src/resources/dice/six.jpg"});
    }
}
