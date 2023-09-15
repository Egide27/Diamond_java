package g51597.diamond.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Egide Kabanza
 */
public class RelicTest {

    /**
     * Test of explore method, of class Relic.
     */
    @Test
    public void testExploreCaseOneExplorerLeaving() {
        Explorer e1 = new Explorer("One");
        List<Explorer> explorers = new ArrayList<>();
        e1.takeDecisionToLeave();
        explorers.add(e1);
        Relic instance = new Relic();
        instance.explore(explorers);
    }

    @Test
    public void testExploreCaseTwooExplorersLeaving() {
        Explorer e1 = new Explorer("One");
        Explorer e2 = new Explorer("Twoo");
        List<Explorer> explorers = new ArrayList<>();
        e1.takeDecisionToLeave();
        e2.takeDecisionToLeave();
        explorers.add(e1);
        explorers.add(e2);
        Relic instance = new Relic();
        instance.explore(explorers);
    }

    @Test
    public void testExploreCase4TakenRelic() {
        Cave cave = new Cave();
        CaveEntrance caveEntrance = new CaveEntrance(cave);
        Explorer e1 = new Explorer("One");
        List<Explorer> explorers = new ArrayList<>();
        e1.takeDecisionToLeave();
        explorers.add(e1);
        Relic instance1 = new Relic();
        Relic instance2 = new Relic();
        Relic instance3 = new Relic();
        caveEntrance.addTileToPath(instance1);
        caveEntrance.addTileToPath(instance2);
        caveEntrance.addTileToPath(instance3);
        instance1.explore(explorers);
        cave.incrementNbTakenRelics();
        instance2.explore(explorers);
        cave.incrementNbTakenRelics();
        cave.incrementNbTakenRelics();
        instance3.explore(explorers);
    }

    /**
     * Test of canBeTaken method, of class Relic.
     */
    @Test
    public void testCanBeTakenCaseTrue() {
        Explorer e1 = new Explorer("One");
        List<Explorer> explorers = new ArrayList<>();
        e1.takeDecisionToLeave();
        explorers.add(e1);
        Relic instance1 = new Relic();
        assertTrue(instance1.canBeTaken(explorers));
    }

    @Test
    public void testCanBeTakenCaseFalseExplorerCamping() {
        Explorer e1 = new Explorer("One");
        List<Explorer> explorers = new ArrayList<>();
        explorers.add(e1);
        Relic instance1 = new Relic();
        assertFalse(instance1.canBeTaken(explorers));
    }

}
