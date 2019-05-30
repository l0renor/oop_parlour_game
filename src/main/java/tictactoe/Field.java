package tictactoe;

import framework.data.AccessoryType;
import framework.data.accessories.Accessory;

public class Field extends Accessory {

    private static final String PATH_TO_FREE_IMAGE = "file:src/resources/tictactoe/field_free.png";
    private static final String PATH_TO_X_IMAGE = "file:src/resources/tictactoe/field_x.png";
    private static final String PATH_TO_0_IMAGE = "file:src/resources/tictactoe/field_o.png";
    private final int col;
    private final int row;

    public Field(int posX, int posY, int col, int row) {
        super(100, 100, posX, posY, 1, PATH_TO_FREE_IMAGE);
        this.col = col;
        this.row = row;
    }

    @Override
    public AccessoryType getAccessoryType() {
        return () -> "Field";
    }

    public void setOccupied(boolean isX) {
        setPathToImage(isX ? PATH_TO_X_IMAGE : PATH_TO_0_IMAGE);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
