package framework.logic;

/**
 * Functional interface to easily define actions for accessories using lambda statements.
 */
public interface Action {

    /**
     * Free to define by the application programmer, can interact with other accessories, is run when the accessory is valid for the turn and clicked.
     */
    void action();

}
