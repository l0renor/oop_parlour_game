package bunny_hop;

import framework.configuration.BoardLayout;
import framework.data.Board;

/**
 * Layout for the bunny game
 */
public class BunnyLayout implements BoardLayout {
    public Board createLayout() {
        final Board board = new Board(1200.0, 800.0, 3, "bunny_hop/background.png", "Bunny Hop");
        board.setInfoText("LEON WHY SO MANY CLASSES?!");
        board.addAccessory(new Field(0, 0));
        board.addAccessory(new Bunny(0, 0, Bunny.BunnyColor.Pink));
        return board;
    }
}
