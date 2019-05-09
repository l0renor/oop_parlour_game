package framework.data;

public class Accessorie implements Comparable<Accessorie> {

    //@TODO should this be abstract or not

    private int sizeX;
    private int sizeY;
    private int posX;
    private int posY;


    private int layer;
    private String pathToBackgground;

    public Accessorie(int sizeX, int sizeY, int posX, int posY, int layer, String pathToBackgground) {
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
     * @param o other Accessorie to be compared to
     * @return int to indicate relation between the objects
     */

    public int compareTo(Accessorie other) {
        return this.layer - other.layer;
    }


}
