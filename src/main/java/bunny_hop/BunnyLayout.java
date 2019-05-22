package bunny_hop;

import framework.configuration.BoardLayout;
import framework.data.Board;
import framework.data.accessories.CardDeck;

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

        String pathToCards[] = new  String[]{"file:src/resources/bunny_hop/cards/carrot.png", "file:src/resources/bunny_hop/cards/one.png", "file:src/resources/bunny_hop/cards/two.png", "file:src/resources/bunny_hop/cards/three.png"};

        board.addAccessory(new CardDeck(130, 230, 240, 420, 2, 300, pathToCards, "file:src/resources/bunny_hop/cards/back_of_card.png"));

        board.addAccessory(new Field(350, 100));
        board.addAccessory(new Field(450, 80));
        board.addAccessory(new Field(550, 100));
        board.addAccessory(new Field(650, 120));
        board.addAccessory(new Field(750, 100));
        board.addAccessory(new Field(850, 80));
        board.addAccessory(new Field(950, 100));
        board.addAccessory(new Field(1050, 140));
        board.addAccessory(new Field(1090, 240));
        board.addAccessory(new Field(1110, 340));
        board.addAccessory(new Field(1090, 440));
        board.addAccessory(new Field(1070, 540));
        board.addAccessory(new Field(1050, 640));
        board.addAccessory(new Field(950, 680));
        board.addAccessory(new Field(850, 700));
        board.addAccessory(new Field(750, 680));
        board.addAccessory(new Field(650, 660));
        board.addAccessory(new Field(550, 680));
        board.addAccessory(new Field(450, 700));
        board.addAccessory(new Field(350, 700));
        board.addAccessory(new Field(250, 700));
        board.addAccessory(new Field(150, 680));
        board.addAccessory(new Field(70, 620));
        board.addAccessory(new Field(50, 520));
        board.addAccessory(new Field(70, 420));
        board.addAccessory(new Field(150, 360));
        board.addAccessory(new Field(250, 320));
        board.addAccessory(new Field(350, 300));
        board.addAccessory(new Field(450, 320));
        board.addAccessory(new Field(550, 340));
        board.addAccessory(new Field(650, 320));
        board.addAccessory(new Field(750, 300));
        board.addAccessory(new Field(850, 340));
        board.addAccessory(new Field(890, 440));
        board.addAccessory(new Field(830, 520));
        board.addAccessory(new Field(730, 540));

        return board;
    }
}
