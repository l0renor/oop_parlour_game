package ludo.accessories;

import framework.data.Point;
import framework.data.accessories.Accessory;
import framework.data.AccessoryType;
import ludo.logic.Fields;
import ludo.logic.LudoAccessoryType;

import java.util.ArrayList;

public class Pawn extends Accessory {

    public enum PawnColor{
        BLUE, GREEN, YELLOW, RED;
    }

    private PawnColor pawnColor;
    private int fieldNumber;
    private int corridorField;
    private Fields fields;
    private Integer index;

    public Pawn(int posX, int posY, PawnColor pawnColor) {
        super(40, 40, posX, posY, 2, "");

        this.pawnColor = pawnColor;
        this.fieldNumber = -1;
        this.index = 0;

        switch(pawnColor){
            case RED:
                this.setPathToImage("file:src/resources/ludo/redpawn.png");
                this.corridorField = 38;
                break;
            case BLUE:
                this.setPathToImage("file:src/resources/ludo/bluepawn.png");
                this.corridorField = 25;
                break;
            case GREEN:
                this.setPathToImage("file:src/resources/ludo/greenpawn.png");
                this.corridorField = 51;
                break;
            case YELLOW:
                this.setPathToImage("file:src/resources/ludo/yellowpawn.png");
                this.corridorField = 12;
                break;
        }
    }

    @Override
    public AccessoryType getAccessoryType() {
        return LudoAccessoryType.PAWN;
    }

    public PawnColor getPawnColor(){
        return pawnColor;
    }

    public int getFieldNumber(){
        return this.fieldNumber;
    }

    public void move(int value){
        Point point = null;
        if(this.fieldNumber == -1 && value == 6){
            index = 1;
            start();
            point = fields.getWhiteFields().get(this.fieldNumber);
        }
        else{
            index += value;
            if(index > 51){
                //Pawn goes to corridor
                ArrayList<Point> corridor = fields.getCorridor(this.pawnColor);
                point = corridor.get(index - 51 - 1);
            }else{
                //Pawn walks the usual path
                this.fieldNumber += value;
                point = fields.getWhiteFields().get(this.fieldNumber);
            }
        }
        this.setPosX((int) point.getX());
        this.setPosY((int) point.getY());
    }

    private void start(){
        switch (this.pawnColor){
            case GREEN:
                this.fieldNumber = 1;
                break;
            case RED:
                this.fieldNumber = 40;
                break;
            case BLUE:
                this.fieldNumber = 27;
                break;
            case YELLOW:
                this.fieldNumber = 14;
                break;
        };
    }
}
