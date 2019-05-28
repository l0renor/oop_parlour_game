package ludo.configuration.four_players;

import framework.configuration.BoardLayout;
import framework.data.Board;
import framework.data.accessories.SixSideDice;
import ludo.accessories.Pawn;

public class FourPlayerLudoLayout implements BoardLayout {
    @Override
    public Board createLayout() {
        final Board board = new Board(600, 600, 2, "file:src/resources/ludo/board.png", "Ludo", "file:src/resources/ludo/icon.jpg");

        board.setInfoText("Hello");

        board.addAccessory(new SixSideDice(40, 40, 10, 500, 1));

        board.addAccessory(new Pawn(110, 70, Pawn.PawnColor.GREEN));
        board.addAccessory(new Pawn(70, 110, Pawn.PawnColor.GREEN));
        board.addAccessory(new Pawn(150, 110, Pawn.PawnColor.GREEN));
        board.addAccessory(new Pawn(110, 150, Pawn.PawnColor.GREEN));

        board.addAccessory(new Pawn(450, 70, Pawn.PawnColor.YELLOW));
        board.addAccessory(new Pawn(410, 110, Pawn.PawnColor.YELLOW));
        board.addAccessory(new Pawn(490, 110, Pawn.PawnColor.YELLOW));
        board.addAccessory(new Pawn(450, 150, Pawn.PawnColor.YELLOW));

        board.addAccessory(new Pawn(110, 410, Pawn.PawnColor.RED));
        board.addAccessory(new Pawn(70, 450, Pawn.PawnColor.RED));
        board.addAccessory(new Pawn(150, 450, Pawn.PawnColor.RED));
        board.addAccessory(new Pawn(110, 490, Pawn.PawnColor.RED));

        board.addAccessory(new Pawn(450, 410, Pawn.PawnColor.BLUE));
        board.addAccessory(new Pawn(410, 450, Pawn.PawnColor.BLUE));
        board.addAccessory(new Pawn(490, 450, Pawn.PawnColor.BLUE));
        board.addAccessory(new Pawn(450, 490, Pawn.PawnColor.BLUE));


        return board;
    }
}
