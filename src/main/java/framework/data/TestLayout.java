package framework.data;

/**
 * Testlayout
 */
public class TestLayout implements BoardLayout {
    public Board createLayout() {
        final Board board = new Board(500.0, 500.0, 2, "background.bmp", "TestGame");
        board.addAccessorie(new TestAccessory(100, 100, 100, 100, 2, "file:src/resources/grill.png")); // this should be done in the builder
        board.addAccessorie(new TestAccessory(100, 100, 180, 230, 1, "file:src/resources/scorpion.png"));
        board.setInfoText("Have a fun game");
        return board;
    }
}
