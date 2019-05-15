package bunny_hop;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;

public class Carrot extends Accessory {

    public Carrot(int posX, int posY) {
        super(100, 100, posX, posY, 1, "file:src/resources/bunny_hop/carrot.png");
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyGameAccessoryType.CARROT;
    }
}
