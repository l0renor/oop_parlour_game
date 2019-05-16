package framework.configuration;

import framework.data.Board;

/**
 * Interface for classes which define the layout of the board.
 * Uses the Strategy Pattern.
 */
public interface BoardLayout {
    /**
     * In this method the application programmer defines the Layout of the board and the accessories.
     *
     * @return the custom layout
     */
    Board createLayout();
}
