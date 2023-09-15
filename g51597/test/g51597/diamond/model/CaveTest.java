package g51597.diamond.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Egide Kabanza
 */
public class CaveTest {

    @Test
    public void hasNewEntranceToExploreTestCaseTrue2ExploredEntrance() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.openNewEntrance();
        assertTrue(cave.hasNewEntranceToExplore());
    }

    @Test
    public void hasNewEntranceToExploreTestCaseFalse5ExploredEntrances() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        assertFalse(cave.hasNewEntranceToExplore());
    }

    @Test(expected = RuntimeException.class)
    public void openNewEntranceTestCaseToMuchExploredEntrance() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        cave.openNewEntrance();
        assertFalse(cave.hasNewEntranceToExplore());
    }

    @Test
    public void openNewEntranceTestCaseEntranceIsOpen() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        assertFalse(cave.getCurrentEntrance().getLockedOut());
    }

    @Test
    public void lockOutCurrentEntrance() {
        Cave cave = new Cave();
        cave.getCurrentEntrance().lockedOut();
        cave.lockOutCurrentEntrance();
        assertTrue(cave.getCurrentEntrance().getLockedOut());
        assertEquals(1, cave.getNbExploredEntrance());
    }
}
