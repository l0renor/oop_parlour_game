package framework.data;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private double sizeX;
    private double sizeY;

    private int numLayers; //layer 0 is background
    private String pathToBackground;
    private String gameName;
    private ArrayList<ArrayList<Accessory>> accessoriesByLayer; // sorted by layer?

    public Board(double sizeX, double sizeY, int numLayers, String pathToBackground, String gameName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.pathToBackground = pathToBackground;
        this.numLayers = numLayers;
        this.accessoriesByLayer = new ArrayList<ArrayList<Accessory>>();
        for (int i = 0; i <= numLayers;i++){
            accessoriesByLayer.add(new ArrayList<Accessory>());
        }
        this.gameName = gameName;
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public String getPathToBackgground() {
        return pathToBackground;
    }

    public List<ArrayList<Accessory>> getAccessoriesByLayer() {
        return accessoriesByLayer;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Adds an accessory to the gameboard
     *
     * @param a accessory to add
     * @return boolean  if success
     */
    public boolean addAccessory(Accessory a) {
        //@TODO check overlap on one layer -> is not allowed
        if (a.getLayer() > numLayers) {
            return false; //@TODO exception?
        } else if (a.getPosX() + a.getSizeX() > sizeX || a.getPosY() + a.getSizeY() > sizeY) {
            return false;
        }
        return accessoriesByLayer.get(a.getLayer()).add(a); //add accessorie to the right layer
    }

    public int getNumLayers(){
        return numLayers;
    }

    public void setNumLayers(int numLayers) {
        this.numLayers = numLayers;
    }

    /**
     * Analyses which accessory was clicked and calls its onclick() function.
     *
     * @param x x position of the mouse
     * @param y y position of the mouse
     */

    public void handleClick(int x, int y) {
        //idea check layer by layer(high -> low) if there is a match call onlick of accessorie
    }
}