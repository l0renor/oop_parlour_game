package framework.data.accessories;

import framework.logic.AccessoryType;
import framework.logic.Action;
import framework.logic.Player;

public abstract class Accessory implements Comparable<Accessory> {

    private int width;
    private int height;
    private int posX;
    private int posY;
    private Action action;
    private Player player;
    private int layer;
    private String pathToImage;

    public Accessory(int width, int height, int posX, int posY, int layer, String pathToImage) {
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.layer = layer;
        this.pathToImage = pathToImage;
        this.player = null;
    }


    /**
     * @precondition player is not null
     * @return player assigned to the Accessory
     *
     */
    public Player getPlayer() {
        return player;
    }

    public Accessory setPlayer(Player player){
        this.player = player;
        return this;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String newPath){
        this.pathToImage = newPath;
    }

    public int getLayer() {
        return layer;
    }

    /**
     * Compare based on layer; high to low
     * @param other other Accessory to be compared to
     * @return int to indicate relation between the objects
     */

    public int compareTo(Accessory other) {
        return this.layer - other.layer;
    }

    public abstract AccessoryType getAccessoryType();

    public Accessory setAction(Action action) {
        this.action = action;
        return this;
    }

    public void doAction() {
        this.action.action();
    }
}
