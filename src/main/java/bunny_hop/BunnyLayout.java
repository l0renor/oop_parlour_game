package bunny_hop;

import framework.configuration.BoardLayout;
import framework.data.Board;

import java.util.ArrayList;

/**
 * Layout for the bunny game
 */
public class BunnyLayout implements BoardLayout {
    public Board createLayout() {
        final Board board = new Board(1200.0, 800.0, 3, "file:src/resources/bunny_hop/background.png", "BUNNY Hop","file:src/resources/bunny_hop/bunny_pink.png");

        board.setInfoText("LEON WHY SO MANY CLASSES?!");

        board.addAccessory(new Carrot(600, 475));

        board.addAccessory(new Bunny(0, 0, Bunny.BunnyColor.PINK));
        board.addAccessory(new Bunny(0, 65, Bunny.BunnyColor.PINK));
        board.addAccessory(new Bunny(0, 130, Bunny.BunnyColor.PINK));
        board.addAccessory(new Bunny(0, 195, Bunny.BunnyColor.PINK));

        board.addAccessory(new Bunny(65, 0, Bunny.BunnyColor.RED));
        board.addAccessory(new Bunny(65, 65, Bunny.BunnyColor.RED));
        board.addAccessory(new Bunny(65, 130, Bunny.BunnyColor.RED));
        board.addAccessory(new Bunny(65, 195, Bunny.BunnyColor.RED));

        board.addAccessory(new Bunny(130, 0, Bunny.BunnyColor.PURPLE));
        board.addAccessory(new Bunny(130, 65, Bunny.BunnyColor.PURPLE));
        board.addAccessory(new Bunny(130, 130, Bunny.BunnyColor.PURPLE));
        board.addAccessory(new Bunny(130, 195, Bunny.BunnyColor.PURPLE));

        board.addAccessory(new Bunny(195, 0, Bunny.BunnyColor.CYAN));
        board.addAccessory(new Bunny(195, 65, Bunny.BunnyColor.CYAN));
        board.addAccessory(new Bunny(195, 130, Bunny.BunnyColor.CYAN));
        board.addAccessory(new Bunny(195, 195, Bunny.BunnyColor.CYAN));

        ArrayList<Field> fieldArrayList = new ArrayList<>();
        fieldArrayList.add(new Field(350, 100));
        fieldArrayList.add(new Field(450, 80));
        fieldArrayList.add(new Field(550, 100));
        fieldArrayList.add(new Field(650, 120));
        fieldArrayList.add(new Field(750, 100));
        fieldArrayList.add(new Field(850, 80));
        fieldArrayList.add(new Field(950, 100));
        fieldArrayList.add(new Field(1050, 140));
        fieldArrayList.add(new Field(1090, 240));
        fieldArrayList.add(new Field(1110, 340));
        fieldArrayList.add(new Field(1090, 440));
        fieldArrayList.add(new Field(1070, 540));
        fieldArrayList.add(new Field(1050, 640));
        fieldArrayList.add(new Field(950, 680));
        fieldArrayList.add(new Field(850, 700));
        fieldArrayList.add(new Field(750, 680));
        fieldArrayList.add(new Field(650, 660));
        fieldArrayList.add(new Field(550, 680));
        fieldArrayList.add(new Field(450, 700));
        fieldArrayList.add(new Field(350, 700));
        fieldArrayList.add(new Field(250, 700));
        fieldArrayList.add(new Field(150, 680));
        fieldArrayList.add(new Field(70, 620));
        fieldArrayList.add(new Field(50, 520));
        fieldArrayList.add(new Field(70, 420));
        fieldArrayList.add(new Field(150, 360));
        fieldArrayList.add(new Field(250, 320));
        fieldArrayList.add(new Field(350, 300));
        fieldArrayList.add(new Field(450, 320));
        fieldArrayList.add(new Field(550, 340));
        fieldArrayList.add(new Field(650, 320));
        fieldArrayList.add(new Field(750, 300));
        fieldArrayList.add(new Field(850, 340));
        fieldArrayList.add(new Field(890, 440));
        fieldArrayList.add(new Field(830, 520));
        fieldArrayList.add(new Field(730, 540));

        fieldArrayList.forEach(board::addAccessory);

        return board;
    }
}
