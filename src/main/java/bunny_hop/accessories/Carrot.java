package bunny_hop.accessories;

import bunny_hop.logic.BunnyHopAccessoryType;
import framework.data.accessories.Accessory;
import framework.data.AccessoryType;

public class Carrot extends Accessory {

    public Carrot(int posX, int posY) {
        super(100, 100, posX, posY, 1, "file:src/resources/bunny_hop/carrot.png");
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyHopAccessoryType.CARROT;
    }
}
