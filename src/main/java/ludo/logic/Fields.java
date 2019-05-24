package ludo.logic;

import framework.data.Point;
import ludo.accessories.Pawn;

public class Fields {


    private CircularList<Point> whiteFields;

    public Fields(){
        whiteFields = new CircularList<>();

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(20 + (i*40), 240));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(240, 210 - (i*40)));

        whiteFields.add(new Point(280, 20));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(320, 20 + (i*40)));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(355 + (i * 40), 240));

        whiteFields.add(new Point(545, 280));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(545, 320 - (i*40)));

        for(int i = 0; i< 6; i++) whiteFields.add(new Point(320, 350 + (i*40)));

        whiteFields.add(new Point(280, 540));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(240, 540 - (i*40)));

        for(int i = 0; i < 6; i++) whiteFields.add(new Point(205 - (i*40), 320));

        whiteFields.add(new Point(20, 280));

    }

    public Point getStartField(Pawn.PawnColor color){
        switch (color){
            case YELLOW:
                return new Point(320, 60);
            case GREEN:
                return new Point(240, 50);
            case BLUE:
                return new Point(505,320);
            case RED:
                return new Point(240, 500);
        }

        return null;
    }

    public boolean isEntryField(Pawn.PawnColor color, Point point){
        switch (color){
            case YELLOW:
                if(point.getX() == 280 && point.getY() == 20)
                    return true;
                else return false;
            case BLUE:
                if(point.getX() == 545 && point.getY() == 280)
                    return true;
                else return false;
            case RED:
                if(point.getX() == 280 && point.getY() == 540)
                    return true;
                else return false;
            case GREEN:
                if(point.getX() == 20 && point.getY() == 280)
                    return true;
                else return false;
        }

        return false;
    }

    public CircularList<Point> getWhiteFields(){
        return whiteFields;
    }
}
