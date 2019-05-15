package bunny_hop;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;

public class Field extends Accessory {

    private static final String PATH_TO_CLOSED_IMAGE = "file:src/resources/bunny_hop/field_closed.png";
    private static final String PATH_TO_OPEN_IMAGE = "file:src/resources/bunny_hop/field_open.png";
    private boolean isOpen = false;

    public Field(int posX, int posY) {
        super(60, 60, posX, posY, 1, "");
        setPathToImage(PATH_TO_CLOSED_IMAGE);
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyGameAccessoryType.FIELD;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
        setPathToImage(isOpen ? PATH_TO_OPEN_IMAGE : PATH_TO_CLOSED_IMAGE);
    }
}
