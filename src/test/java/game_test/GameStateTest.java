package game_test;

import bunny_hop.logic.BunnyHopGameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameStateTest {
    @Test
    void testOccupiedFields(){
        BunnyHopGameState gs = new BunnyHopGameState();
        assertTrue(gs.occupyField(0));
        assertFalse(gs.occupyField(0) );
        gs.freeField(0);
        assertTrue( gs.occupyField(0) );


    }
}

