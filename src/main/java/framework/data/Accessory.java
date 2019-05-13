package framework.data;

public abstract class Accessory implements Comparable<Accessory> {

    private int sizeX;
    private int sizeY;
    private int posX;
    private int posY;


    private int layer;
    private String pathToBackground;

    public Accessory(int sizeX, int sizeY, int posX, int posY, int layer, String pathToBackground) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.posX = posX;
        this.posY = posY;
        this.layer = layer;
        this.pathToBackground = pathToBackground;
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

    public String getPathToBackground() {
        return pathToBackground;
    }

    public void setPathToImage(String newPath){
        this.pathToImage = newPath;
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
