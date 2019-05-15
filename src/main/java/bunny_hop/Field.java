package bunny_hop;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;

public class Field extends Accessory {

    private final String pathToClosedImage = "file:src/resources/bunny_hop/field_closed.png";
    private final String pathToOpenImage = "file:src/resources/bunny_hop/field_open.png";
    private boolean isOpen = false;

    public Field(int posX, int posY) {
        super(60, 60, posX, posY, 1, "");
        setPathToImage(pathToClosedImage);
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyGameAccessoryType.Field;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
        setPathToImage(isOpen ? pathToOpenImage : pathToClosedImage);
    }
}
