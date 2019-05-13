package framework;

/**
 * An abstract base class for the player to be extended by the application programmer.
 */
public abstract class Player {

    private final String name;
    private boolean isOut = false;

    /**
     * Creates a new player.
     * @param name The players name.
     * @precondition name is not null, name is not an empty string.
     * @postcondition A valid player object is returned.
     */
    public Player(String name) {
        assert name != null : "Parameter 'name' mustn't be 'null'.";
        assert !name.equals("") : "Parameter 'name' must have content.";
        this.name = name;
    }

    /**
     * Returns the players name, which is final.
     * @return A string representing the players name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns true if player is out of the running game, else false.
     * @return a boolean value describing the players state in a running game.
     * @precondition The game has to be running while this is called.
     */
    public boolean isOut() {
        return isOut;
    }

    /**
     * Throws this players out of the current game.
     * @precondition The game has to be running while this is called.
     */
    public void throwOut() {
        isOut = true;
    }
}
