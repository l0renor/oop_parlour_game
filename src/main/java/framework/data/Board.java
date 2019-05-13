package framework.data;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private double width;
    private double height;
    private String infoText;

    /**
     * the number of layers on the game board; excluding the background
     */
    private int numLayers; //layer 0 is background
    /**
     * path to the backgroundimage e.g. "file:src/resources/board.png"
     */
    private String pathToBackgground;
    /**
     * The name of the game; displayed above the canvas
     */
    private String gameName;

    private ArrayList<ArrayList<Accessory>> accessoriesByLayer;

    /**
     * Getter for width of the gameboard/canvas.
     * @return width of the gameboard/canvas.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Getter for height of the gameboard/canvas.
     * @return height of the gameboard/canvas.
     */
    public double getHeight() {
        return height;
    }

    public String getPathToBackgground() {
        return pathToBackgground;
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
     * Getter for the infotext displayed below the gameboard; e.g. for instructions
     * @return the infotext
     */
    public String getInfoText() {
        return infoText;
    }

    /**
     * Setter for infotext displayed below the gameboard; e.g. for instructions
     * @param infoText the new info text; the old one is deleted
     */
    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    /**
     * Constructor of a game bord.
     * @param width of the board
     * @param height of the board
     * @param numLayers graphical layers on the board
     * @param pathToBackgground path to the backgroundimage e.g. "file:src/resources/board.png"
     * @param gameName name of the game
     */
    public Board(double width, double height, int numLayers, String pathToBackgground, String gameName) {
        this.width = width;
        this.height = height;
        this.pathToBackgground = pathToBackgground;
        this.numLayers = numLayers;
        this.accessoriesByLayer = new ArrayList<ArrayList<Accessory>>();
        for (int i = 0; i <= numLayers;i++){
            accessoriesByLayer.add(new ArrayList<Accessory>());
        }
        this.gameName = gameName;
        this.infoText = "";
    }

    /**
     * Adds an accessorie to the gameboard.     *
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessorie(Accessory a) {
        //@TODO check overlapp on one layer -> is not allowed
        if (a.getLayer() > numLayers) {
            return false; //@TODO exception?
        } else if (a.getPosX() + a.getSizeX() > width || a.getPosY() + a.getSizeY() > height) {
            return false;
        }
        return accessoriesByLayer.get(a.getLayer()).add(a); //add accessorie to the right layer
    }

    /**
     * Number of graphical layers on the canvas.
     * The background is excluded
     * @return the number of layers
     */
    public int getNumLayers(){
        return numLayers;
    }

}

