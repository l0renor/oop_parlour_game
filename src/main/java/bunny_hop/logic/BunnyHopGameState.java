package bunny_hop.logic;

import bunny_hop.accessories.Field;
import framework.logic.GameState;
import framework.logic.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BunnyHopGameState extends GameState {

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

    private CardValue cardValue;
    private ArrayList<Field> occupiedFields = new ArrayList<>();

    @Override
    public boolean isTurnRepeated() {
        return false;
    }

    @Override
    public void setTurnRepeated(boolean repeated) {
        // SWYM
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

}
