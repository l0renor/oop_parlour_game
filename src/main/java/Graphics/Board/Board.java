package main.java.Graphics.Board;

import main.java.Graphics.accessories.Accessorie;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private int sizeX;
    private int sizeY;
    private int numLayers;
    private String pathToBackgground;
    private List<Accessorie> accessories; // sorted by layer?
    //private JavaFx application

    public Board(int sizeX, int sizeY, int numLayers,String pathToBackgground) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.pathToBackgground = pathToBackgground;
        //@TODO load img;
        this.numLayers = numLayers;
        this.accessories = new ArrayList<Accessorie>();
    }

    /**
     * Adds an accessorie to the gameboard
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessorie(Accessorie a) {
        if (a.getLayer() > numLayers) {
            return false;
        } else if (a.getPosX() + a.getSizeX() > sizeX || a.getPosY() + a.getSizeY() > sizeY) {
            return false;
        }
        return accessories.add(a);
    }

    public int getNumLayers() {
        return numLayers;
    }

    public void setNumLayers(int numLayers) {
        this.numLayers = numLayers;
    }

    /**
     * Analyses which accessorie was clicked and calls its onclick() function.
     *
     * @param x x position of the mouse
     * @param y y position of the mouse
     */

    public void handleClick(int x, int y) {
        //idea check layer by layer(high -> low) if there is a match call onlick of accessorie
    }

    /**
     * Draws the Gmaeboard with its accessories.
     */
    public void draw() {
        //fx stuff here
    }
}
