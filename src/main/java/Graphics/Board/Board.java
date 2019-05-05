package main.java.Graphics.Board;

import main.java.Graphics.accessories.Accessorie;

import java.util.List;

public class Board {
    public Board(int sizeX, int sizeY, int numLayers) {

    }

    private int sizeX;
    private int sizeY;
    private int numLayers;
    private String pathToBackgground;
    private List<Accessorie> accessories; // sorted by layer?
    //private JavaFx application


    public boolean addAccessorie(Accessorie a) {
        if (a.getLayer() > numLayers) {
            return false;
        } else if (a.getPosX() + a.getSizeX() > sizeX || a.getPosY() + a.getSizeY() > sizeY) {
            return false;
        }
        return accessories.add(a);
    }

    /**
     * Analyses which accessorie was clicked and calls its onclick() function.
     *
     * @param x x position of the mouse
     * @param y y position of the mouse
     */
    public void handleClick(int x, int y) {

    }

    /**
     * Draws the Gmaeboard with its accessories.
     */
    public void draw() {
        //fx stuff here
    }
}
