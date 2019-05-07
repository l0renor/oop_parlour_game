package framework;

/**
 * Interface to specify the game mode (strategy pattern)
 */
public interface GameMode {

    /**
     * Indicates the set number of players for the individual game mode.
     * @return number of players as 'int'.
     */
    int getNumberOfPlayers();

    /**
     * Constructs a player, can be inheriting class from Player.
     * @return constructed Player object.
     */
    Player constructPlayer();

    //@TODO More strategy methods, for example ruleset.

}
