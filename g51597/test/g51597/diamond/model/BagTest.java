package g51597.diamond.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class BagTest {

    @Test
    public void getNbRubiesCaseNoRuby() {
        Bag bag = new Bag();
        assertEquals(0, bag.getValue());
    }

    @Test
    public void addGemsOneTime() {
        Bag bag = new Bag();
        Gem gem1 = Gem.RUBY;
        bag.addGem(gem1);

        assertEquals(1, bag.getGems().size());
    }

    @Test
    public void addGemsTwoTime() {
        Bag bag = new Bag();
        bag.addGem(Gem.DIAMOND);
        bag.addGem(Gem.RUBY);
        assertEquals(6, bag.getValue());
    }

    @Test
    public void equalsTestTrueAfterInit() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        assertTrue(bag1.equals(bag2));
    }

    @Test
    public void equalsTestTrueAfterAdding() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        bag1.addGem(Gem.RUBY);
        bag2.addGem(Gem.RUBY);
        assertTrue(bag1.equals(bag2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Bag bag1 = new Bag();
        String bag2 = "bag2";
        assertFalse(bag1.equals(bag2));
    }

    @Test
    public void equalsFalseNull() {
        Bag bag1 = new Bag();
        assertFalse(bag1.equals(null));
    }

    @Test
    public void loseContentTest() {
        Bag bag = new Bag();
        bag.addGem(Gem.DIAMOND);
        bag.loseContest();
        assertEquals(0, bag.getValue());
    }
}
