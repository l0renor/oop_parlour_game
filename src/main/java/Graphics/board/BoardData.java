package Graphics.board;

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

    public List<List<Accessorie>> getAccessoriesByLayer() {
        return accessoriesByLayer;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    private int numLayers; //layer 0 is background
    private String pathToBackgground;
    private String gameName;
    private List<List<Accessorie>> accessoriesByLayer; // sorted by layer?
    //private JavaFx application

    public BoardData(double sizeX, double sizeY, int numLayers, String pathToBackgground, String gameName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.pathToBackgground = pathToBackgground;
        this.numLayers = numLayers;
        this.accessoriesByLayer = new ArrayList<List<Accessorie>>();
        for (int i = 0; i<= numLayers;i++){
            accessoriesByLayer.add(new ArrayList<Accessorie>());
        }
        this.gameName = gameName;
    }

    /**
     * Adds an accessorie to the gameboard
     *
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessorie(Accessorie a) {
        //@TODO check overlapp on one layer -> is not allowed
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
     * Analyses which accessorie was clicked and calls its onclick() function.
     *
     * @param x x position of the mouse
     * @param y y position of the mouse
     */

    public void handleClick(int x, int y) {
        //idea check layer by layer(high -> low) if there is a match call onlick of accessorie
    }
}

