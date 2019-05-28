package framework_test;

import bunny_hop.accessories.Bunny;
import framework.data.Board;
import framework.data.accessories.SixSideDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testAdd(){
        Board board = new Board(1200.0, 800.0, 3, "file:src/resources/bunny_hop/background.png", "BUNNY Hop","file:src/resources/bunny_hop/bunny_pink.png");
        //Test wrong layer
        assertFalse(board.addAccessory(new SixSideDice(20,20,20,20,8)));
        //Test overlapping prevention
        assertTrue(board.addAccessory(new Bunny(0, 0, Bunny.BunnyColor.PINK)));
        assertFalse(board.addAccessory(new Bunny(1, 10, Bunny.BunnyColor.PINK)));


    }
    @Test
    void testRestetActions(){
        final int[] test = {0};
        Board board = new Board(1200.0, 800.0, 3, "file:src/resources/bunny_hop/background.png", "BUNNY Hop","file:src/resources/bunny_hop/bunny_pink.png");
        Bunny bunny = new Bunny(50,50, Bunny.BunnyColor.PINK);
        board.addAccessory(bunny);
        bunny.setAction(() -> test[0]++);
        bunny.doAction();
        assertEquals(1,test[0]);
        board.resetAllActions();
        bunny.doAction();
        assertEquals(1,test[0]);
    }
}
