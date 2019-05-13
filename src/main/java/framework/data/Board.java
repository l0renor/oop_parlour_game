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
    private double width;
    private double height;
    private String infoText;
  
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


    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public String getPathToBackground() {
        return pathToBackground;
    }

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
     * Setter for infotext displayed below the gameboard; e.g. for instructions
     * @param infoText the new info text; the old one is deleted
     */
    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }



    /**
     * Adds an accessorie to the gameboard.     *
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessory(Accessory a) {
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

    public void setNumLayers(int numLayers) {
        this.numLayers = numLayers;
    }
 
}

