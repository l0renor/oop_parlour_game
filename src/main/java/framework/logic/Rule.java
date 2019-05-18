package framework.logic;

import framework.data.Board;

import java.util.ArrayList;

public interface Rule {
    ArrayList<AccessoryType> getValidAccessoryTypes();
    void setValidActions(GameState state, Board board);
}
