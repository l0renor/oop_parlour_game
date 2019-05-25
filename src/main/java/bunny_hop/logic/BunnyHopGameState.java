package bunny_hop.logic;

import bunny_hop.accessories.Field;
import framework.logic.GameState;
import framework.logic.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BunnyHopGameState implements GameState {

    public enum CardValue {

        ONE(1), TWO(2), THREE(3), CARROT(0);

        private int number;

        CardValue(int number) {
            this.number = number;
        }

        public int getNumber() {
            return this.number;
        }

    }

    private Player activePlayer;
    private CardValue cardValue;
    private ArrayList<Field> occupiedFields = new ArrayList<>();
    private int[] holes = new int [2];


    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    @Override
    public boolean isTurnRepeated() {
        return false;
    }

    @Override
    public void setTurnRepeated(boolean repeated) {
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public boolean occupyField(Field field) {
        if (occupiedFields.contains(field)) {
            return false;
        } else {
            occupiedFields.add(field);
            return true;
        }
    }
    public void freeField(Field field) {
        occupiedFields.remove(field);
    }

    /**
     * Sets teh fields where the player is reset to the starting position.
     * @param fieldNumbers the new fieldnumbers
     */
    public void setHoles(int[] fieldNumbers){
        holes = fieldNumbers;
    }

    /**
     * Checks if a field is carrot blocked
     * @param fieldnumber the field to be checked
     * @return whether the field is blocked
     */
    public boolean isHole(int fieldnumber){
        return IntStream.of(holes).anyMatch(x -> x == fieldnumber);
    }



}
