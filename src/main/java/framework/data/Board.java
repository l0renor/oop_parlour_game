package framework.data;

import framework.data.accessories.Accessory;
import framework.logic.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private double width;
    private double height;
    private String infoText;
    private int numberOfLayers; // Layer 0 is background
    private String pathToBackground;
    private String pathToIcon;
    private String gameName;
    private ArrayList<ArrayList<Accessory>> accessoriesByLayer;


    /**
     * Constructor of a game bord.
     *
     * @param width            of the board
     * @param height           of the board
     * @param numberOfLayers        graphical layers on the board
     * @param pathToBackground path to the backgroundimage e.g. "file:src/resources/board.png"
     * @param gameName         name of the game
     */
    public Board(double width, double height, int numberOfLayers, String pathToBackground, String gameName, String pathToIcon) {
        this.width = width;
        this.height = height;
        this.pathToBackground = pathToBackground;
        this.numberOfLayers = numberOfLayers;
        this.pathToIcon = pathToIcon;
        this.accessoriesByLayer = new ArrayList<>();
        for (int i = 0; i <= numberOfLayers; i++) {
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

    public List<ArrayList<Accessory>> getAccessories() {
        return accessoriesByLayer;
    }

    public List<Accessory> getAccessories(int layer) {
        return ((layer > numberOfLayers) || (layer < 1)) ? null : accessoriesByLayer.get(layer);
    }

    public List<Accessory> getAccessories(int layer, AccessoryType accessoryType) {
        return ((layer > numberOfLayers) || (layer < 1)) ? null : accessoriesByLayer.get(layer).stream().filter(accessory -> accessory.getAccessoryType() == accessoryType).collect(Collectors.toList());
    }

    public List<Accessory> getAccessories(int layer, AccessoryType accessoryType, Player player) {
        return ((layer > numberOfLayers) || (layer < 1)) ? null : accessoriesByLayer.get(layer).stream().filter(accessory -> accessory.getAccessoryType() == accessoryType && accessory.getPlayer() == player).collect(Collectors.toList());
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
     * Adds an accessory to the board.     *
     *
     * @param a accessory to add
     * @return whether the adding  was successful
     */
    public boolean addAccessory(Accessory a) {
        if (a.getLayer() > numberOfLayers) {
            return false;
        } else if (a.getPosX() + a.getWidth() > width || a.getPosY() + a.getHeight() > height) {
            return false;
        }

        for (Accessory accessorie : accessoriesByLayer.get(a.getLayer())) {
            if (in(a, accessorie.getPosX(), accessorie.getPosY()) || in(a, accessorie.getPosX() + accessorie.getWidth(), accessorie.getPosY()) ||
                    in(a, accessorie.getPosX(), accessorie.getPosY() + accessorie.getHeight()) || in(a, accessorie.getPosX() + accessorie.getWidth(), accessorie.getPosY() + accessorie.getHeight())
                    || in(accessorie, a.getPosX(), a.getPosY()) || in(accessorie, a.getPosX() + a.getWidth(), a.getPosY()) ||
                    in(accessorie, a.getPosX(), a.getPosY() + a.getHeight()) || in(accessorie, a.getPosX() + a.getWidth(), a.getPosY() + a.getHeight())
            ) {
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
    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    /**
     * Sets the action value of all accessories on the board to nothing.
     */
    public void resetAllActions() {
        for (final List<Accessory> layer : getAccessories()) {
            for (Accessory accessory : layer) {
                accessory.setAction(() -> {
                });
            }
        }
    }

    private boolean in(Accessory a, int x, int y) {
        return x > a.getPosX() && x < a.getPosX() + a.getWidth() && y > a.getPosY() && y < a.getPosY() + a.getHeight();
    }


}

