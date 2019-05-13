package framework.data;

public abstract class Accessory implements Comparable<Accessory> {

    private int sizeX;
    private int sizeY;
    private int posX;
    private int posY;


    private int layer;
    private String pathToBackgground;

    public Accessory(int sizeX, int sizeY, int posX, int posY, int layer, String pathToBackgground) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.posX = posX;
        this.posY = posY;
        this.layer = layer;
        this.pathToBackgground = pathToBackgground;
    }


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getPathToBackgground() {
        return pathToBackgground;
    }

    public int getLayer() {
        return layer;
    }

    /**
     * Compare based on layer; high to low
     * @param o other Accessory to be compared to
     * @return int to indicate relation between the objects
     */

    public int compareTo(Accessory other) {
        return this.layer - other.layer;
    }


}
