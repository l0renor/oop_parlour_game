package bunny_hop.accessories;

import bunny_hop.logic.BunnyHopAccessoryType;
import framework.data.accessories.Accessory;
import framework.data.AccessoryType;

public class Bunny extends Accessory {

    public enum BunnyColor {
        CYAN, PINK, PURPLE, RED
    }

    private int startPosX;
    private int startPosY;
    private int fieldNumber = 0;
    private BunnyColor bunnyColor;

    public Bunny(int startPosX, int startPosY, BunnyColor bunnyColor) {
        super(60, 60, startPosX, startPosY, 2, "");
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.bunnyColor = bunnyColor;
        switch (bunnyColor) {
            case RED:
                setPathToImage("file:src/resources/bunny_hop/bunny_red.png");
                break;
            case PURPLE:
                setPathToImage("file:src/resources/bunny_hop/bunny_purple.png");
                break;
            case CYAN:
                setPathToImage("file:src/resources/bunny_hop/bunny_cyan.png");
                break;
            case PINK:
                setPathToImage("file:src/resources/bunny_hop/bunny_pink.png");
                break;
        }
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyHopAccessoryType.BUNNY;
    }

    public void resetToStartPos() {
        this.setPosX(startPosX);
        this.setPosY(startPosY);
        this.fieldNumber = 0;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public BunnyColor getBunnyColor() {
        return bunnyColor;
    }
}
