package Graphics.Board;

import Graphics.accessories.Accessorie;

import java.util.ArrayList;
import java.util.List;

public class BoardData {


    private double sizeX;
    private double sizeY;

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public String getPathToBackgground() {
        return pathToBackgground;
    }

    public List<Accessorie> getAccessories() {
        return accessories;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    private int numLayers;
    private String pathToBackgground;
    private String gameName;
    private List<Accessorie> accessories; // sorted by layer?
    //private JavaFx application

    public BoardData(double sizeX, double sizeY, int numLayers, String pathToBackgground, String gameName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.pathToBackgground = pathToBackgground;
        //@TODO load img;
        this.numLayers = numLayers;
        this.accessories = new ArrayList<Accessorie>();
        this.gameName = gameName;
    }

    /**
     * Adds an accessorie to the gameboard
     *
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessorie(Accessorie a) {
        //@TODO check overlapp on one layer
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
}

