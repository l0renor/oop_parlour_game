package main.java.Graphics.accessories;

public abstract class Accessorie {

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

    public abstract void draw();

    public abstract void onClick();

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


}
