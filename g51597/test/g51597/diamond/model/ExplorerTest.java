package g51597.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorerTest {

    @Test
    public void getPseudonyme() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals("Sdr", explorer.getPseudonym());
    }

    @Test
    public void getStateBeforeTakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(State.CAMPING, explorer.getState());
    }

    @Test
    public void getStateAftertakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        explorer.takeDecisionToLeave();
        assertEquals(State.LEAVING, explorer.getState());
    }

    @Test
    public void getBagBeforAddingToBag() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(0, explorer.getBag().getValue());
    }

    @Test
    public void addToBag1Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(Gem.DIAMOND);
        assertEquals(5, explorer.getBag().getValue());
    }

    @Test
    public void addToBag2Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(Gem.RUBY);
        explorer.addToBag(Gem.DIAMOND);
        assertEquals(6, explorer.getBag().getValue());
    }

    @Test
    public void equalsTrue() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("mcd");
        assertTrue(e1.equals(e2));
    }

    @Test
    public void equalsFalseDifferent() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("pbt");
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Explorer e1 = new Explorer("mcd");
        String e2 = "mcd";
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseNull() {
        Explorer e1 = new Explorer("mcd");
        assertFalse(e1.equals(null));
    }

    @Test
    public void getFortuneCaseOk() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(Gem.DIAMOND);
        explorer.addToBag(Gem.RUBY);
        assertEquals(6, explorer.getFortune());
    }

    @Test
    public void reachCampTest() {
        Explorer e1 = new Explorer("Un");
        e1.reachCamp();
        assertEquals(State.CAMPING, e1.getState());
    }

    @Test
    public void startExplorationTest() {
        Explorer ex1 = new Explorer("Un");
        Explorer ex2 = new Explorer("Deux");
        assertEquals(State.CAMPING, ex1.getState());
        assertEquals(State.CAMPING, ex2.getState());
    }

    @Test
    public void runAwayTest() {
        Explorer ex1 = new Explorer("Un");
        ex1.getBag().addGem(Gem.DIAMOND);
        ex1.runAway();
        assertEquals(0, ex1.getFortune());
        assertEquals(State.CAMPING, ex1.getState());
    }
}
