package framework_test;

import framework.data.AccessoryType;
import framework.data.BasicAccessoryType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTypeTest {

    enum newEnum implements AccessoryType {
        CARD_DECK;

        @Override
        public String getAccessoryTypeName() {
            return "CARD_DECK";
        }
    }

    @Test
    void doubleEnumTest() {
        assertSame(BasicAccessoryType.accessoryTypeFor("CARD_DECK"), BasicAccessoryType.CARD_DECK);
        assertFalse(BasicAccessoryType.addNewAccessoryType(newEnum.CARD_DECK));
    }

    @Test
    void enumAndAnonymusClassTest() {
        assertSame(BasicAccessoryType.accessoryTypeFor("CARD_DECK"), BasicAccessoryType.CARD_DECK);
        assertFalse(BasicAccessoryType.addNewAccessoryType(()->"CARD_DECK"));
    }

    @Test
    void doubleAnonymusClassTest() {
        AccessoryType accessoryType = ()->"TEST";
        assertTrue(BasicAccessoryType.addNewAccessoryType(accessoryType));
        assertEquals(BasicAccessoryType.accessoryTypeFor("TEST"), accessoryType);
        assertFalse(BasicAccessoryType.addNewAccessoryType(()->"TEST"));
    }
}
