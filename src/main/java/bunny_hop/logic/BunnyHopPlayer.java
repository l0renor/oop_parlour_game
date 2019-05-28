package bunny_hop.logic;

import framework.logic.Player;

public class BunnyHopPlayer extends Player {

    private int activeBunnys;

    /**
     * Creates a new player.
     *
     * @param name The players name.
     * @precondition name is not null, name is not an empty string.
     * @postcondition A valid player object is returned.
     */
    public BunnyHopPlayer(String name) {
        super(name);
        activeBunnys = 4;
    }

    public void finishBunny() {
        activeBunnys--;
        if (activeBunnys == 0) {
            super.throwOut();
        }
    }
}
