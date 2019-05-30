package framework_test;

import framework.data.accessories.CardDeck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDeckTest {
    @Test
    void shuffleTest(){
        String[] pathToCards = new String[]{"file:src/resources/bunny_hop/cards/carrot.png", "file:src/resources/bunny_hop/cards/one.png", "file:src/resources/bunny_hop/cards/two.png", "file:src/resources/bunny_hop/cards/three.png"};
        CardDeck cd = new CardDeck(130, 230, 240, 420, 2, 300, pathToCards, "file:src/resources/bunny_hop/cards/back_of_card.png");
        for(int i = 0; i < 20; i++){
            int res = cd.pickCard();
            assertEquals(cd.getPathToImage(),pathToCards[res]);
            res = cd.pickCard(); //flip back to hidden state
            assertEquals(res,-1);
        }


    }
}
