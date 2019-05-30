package ludo.logic;

import framework.data.Point;
import ludo.accessories.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Fields {


    private CircularList<Point> whiteFields;
    private ArrayList<Point> greenFields;
    private ArrayList<Point> blueFields;
    private ArrayList<Point> yellowFields;
    private ArrayList<Point> redFields;

    public Fields() {
        whiteFields = new CircularList<>();
        blueFields = new ArrayList<>();
        greenFields = new ArrayList<>();
        yellowFields = new ArrayList<>();
        redFields = new ArrayList<>();

        for (int i = 0; i < 6; i++) whiteFields.add(new Point((double) 20 + (i * 40), 240));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point( 240, (double) 210 - (i * 40)));

        whiteFields.add(new Point(280, 20));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point(320, (double) 20 + (i * 40)));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point((double) 355 + (i * 40), 240));

        whiteFields.add(new Point(545, 280));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point((double) 545 - (i * 40), 320));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point( 320, (double) 350 + (i * 40)));

        whiteFields.add(new Point(280, 540));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point(240, 540 - (double) (i * 40)));

        for (int i = 0; i < 6; i++) whiteFields.add(new Point((double) 205 - (i * 40), 320));

        whiteFields.add(new Point(20, 280));

        for (int i = 0; i < 6; i++) greenFields.add(new Point((double) 50 + (i * 40), 280));
        for (int i = 0; i < 6; i++) yellowFields.add(new Point(280, (double) 50 + (i * 40)));
        for (int i = 0; i < 6; i++) blueFields.add(new Point((double) 505 - (i * 40), 280));
        for (int i = 0; i < 6; i++) redFields.add(new Point(280, (double) 505 - (i * 40)));

    }


    public List<Point> getCorridor(Pawn.PawnColor color) {
        switch (color) {
            case YELLOW:
                return yellowFields;
            case BLUE:
                return blueFields;
            case RED:
                return redFields;
            case GREEN:
                return greenFields;
        }

        return new ArrayList<>();
    }


    public CircularList<Point> getWhiteFields() {
        return whiteFields;
    }
}
