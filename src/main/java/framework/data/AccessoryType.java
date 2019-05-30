package framework.data;

/**
 * Interface to be implemented by game-specific enums, should work together with the already provided BasicAccessoryType enum.
 */
public interface AccessoryType {

    /**
     * Returns the name of the Accessory Type the object represents.
     * @return Name as string value.
     */
    String getAccessoryTypeName();

}