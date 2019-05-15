package bunny_hop;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;

public class Bunny extends Accessory {

    enum BunnyColor {
        Pink, Purple, Cyan, Red
    }

    private int startPosX;
    private int startPosY;
    private int fieldNumber;

    public Bunny(int startPosX, int startPosY, BunnyColor bunnyColor) {
        super(60, 60, startPosX, startPosY, 2, "");
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        switch (bunnyColor) {
            case Red:
                setPathToImage("file:src/resources/bunny_hop/bunny_red.png");
                break;
            case Purple:
                setPathToImage("file:src/resources/bunny_hop/bunny_purple.png");
                break;
            case Cyan:
                setPathToImage("file:src/resources/bunny_hop/bunny_cyan.png");
                break;
            case Pink:
                setPathToImage("file:src/resources/bunny_hop/bunny_pink.png");
                break;
        }
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BunnyGameAccessoryType.Bunny;
    }

    public void resetToStartPos() {
        setPosX(startPosX);
        setPosY(startPosY);
    }
}
