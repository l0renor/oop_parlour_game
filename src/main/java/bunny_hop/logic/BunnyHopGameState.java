package bunny_hop.logic;

import framework.logic.GameState;
import framework.logic.Player;

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

    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

}
