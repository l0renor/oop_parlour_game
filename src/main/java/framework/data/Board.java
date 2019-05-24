package framework.data;

import framework.data.accessories.Accessory;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private double width;
    private double height;
    private String infoText;
    private int numLayers; //layer 0 is background
    private String pathToBackground;
    private String pathToIcon;
    private String gameName;
    private ArrayList<ArrayList<Accessory>> accessoriesByLayer;


    /**
     * Constructor of a game bord.
     *
     * @param width            of the board
     * @param height           of the board
     * @param numLayers        graphical layers on the board
     * @param pathToBackground path to the backgroundimage e.g. "file:src/resources/board.png"
     * @param gameName         name of the game
     */
    public Board(double width, double height, int numLayers, String pathToBackground, String gameName, String pathToIcon) {
        this.width = width;
        this.height = height;
        this.pathToBackground = pathToBackground;
        this.numLayers = numLayers;
        this.pathToIcon = pathToIcon;
        this.accessoriesByLayer = new ArrayList<ArrayList<Accessory>>();
        for (int i = 0; i <= numLayers; i++) {
            accessoriesByLayer.add(new ArrayList<Accessory>());
        }
        this.gameName = gameName;
        this.infoText = "";
    }

    /**
     * Getter for width of the gameboard/canvas.
     *
     * @return width of the gameboard/canvas.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Getter for height of the gameboard/canvas.
     *
     * @return height of the gameboard/canvas.
     */
    public double getHeight() {
        return height;
    }

    public String getPathToBackground() {
        return pathToBackground;
    }

    public String getPathToIcon() {
        return pathToIcon;
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
     *
     * @return the infotext
     */
    public String getInfoText() {
        return infoText;
    }

    /**
     * Setter for infotext displayed below the gameboard; e.g. for instructions
     *
     * @param infoText the new info text; the old one is deleted
     */
    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public void appendToInfoText(String toAppend) {
        this.infoText += "\n" + toAppend;
    }

    /**
     * Adds an accessorie to the gameboard.     *
     *
     * @param a accessorie to add
     * @return boolean  if sucsess
     */
    public boolean addAccessory(Accessory a) {
        if (a.getLayer() > numLayers) {
            return false; //@TODO exception?
        } else if (a.getPosX() + a.getWidth() > width || a.getPosY() + a.getHeight() > height) {
            return false;
        }

        for (Accessory accessorie : accessoriesByLayer.get(a.getLayer())) {
            if (in(a, accessorie.getPosX(), accessorie.getPosY()) || in(a, accessorie.getPosX() + accessorie.getWidth(), accessorie.getPosY()) ||
                    in(a, accessorie.getPosX(), accessorie.getPosY() + accessorie.getHeight()) || in(a, accessorie.getPosX() + accessorie.getWidth(), accessorie.getPosY() + accessorie.getHeight())
            ||in(accessorie, a.getPosX(), a.getPosY()) || in(accessorie, a.getPosX() + a.getWidth(), a.getPosY()) ||
                    in(accessorie, a.getPosX(), a.getPosY() + a.getHeight()) || in(accessorie, a.getPosX() + a.getWidth(), a.getPosY() + a.getHeight())
            )
            {
                return false;
            }
        }
        return accessoriesByLayer.get(a.getLayer()).add(a);
    }

    /**
     * Number of graphical layers on the canvas.
     * The background is excluded
     *
     * @return the number of layers
     */
    public int getNumLayers() {
        return numLayers;
    }

    private boolean in(Accessory a, int x, int y) {
        if (x > a.getPosX() && x < a.getPosX() + a.getWidth() && y > a.getPosY() && y < a.getPosY() + a.getHeight()) {
            return true;
        }
        return false;
    }

}

