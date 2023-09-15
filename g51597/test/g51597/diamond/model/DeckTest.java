package g51597.diamond.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Egide Kabanza
 */
public class DeckTest {

    @Test
    public void test() {
        Deck deck = new Deck();
        assertFalse(deck.getTiles().isEmpty());
    }

    @Test
    public void getTreasureTest() {
        Deck deck = new Deck();
        int size1 = deck.getTiles().size();
        Tile tile = deck.getTile();
        int size2 = deck.getTiles().size();
        assertEquals(size1 - 1, size2);
    }

    @Test
    public void putBackTest() {
        Deck deck = new Deck();
        int size1 = deck.getTiles().size();
        Tile tile = deck.getTile();
        deck.putBack(tile);
        int size2 = deck.getTiles().size();
        assertEquals(size1, size2);

    }

}
