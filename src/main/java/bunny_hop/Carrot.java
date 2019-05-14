package bunny_hop;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;

public class Carrot extends Accessory {

    public Carrot(int width, int height, int posX, int posY, int layer) {
        super(width, height, posX, posY, layer, "");
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyGameAccessoryType.Carrot;
    }
}
