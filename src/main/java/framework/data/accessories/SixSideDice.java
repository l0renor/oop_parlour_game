package framework.data.accessories;

public class SixSideDice extends Dice {

    public SixSideDice(int width, int height, int posX, int posY, int layer) {
        super(width, height, posX, posY, layer, new String[] {"file:src/resources/framework/dice/one.jpg", "file:src/resources/framework/dice/two.jpg", "file:src/resources/framework/dice/three.jpg", "file:src/resources/framework/dice/four.jpg", "file:src/resources/framework/dice/five.jpg", "file:src/resources/framework/dice/six.jpg"});
    }

}
