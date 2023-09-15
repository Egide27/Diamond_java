package g51597.diamond.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TreasureExplorerTest {

    @Test
    public void explore1ExplorerExplorerBag() {
        Explorer e1 = new Explorer("e1");
        Treasure treasure = new Treasure(4);
        treasure.explore(Arrays.asList(e1));
        assertEquals(e1.getBag().getValue(), 4);
    }

    @Test
    public void explore2ExplorerExplorerBag() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Treasure treasure = new Treasure(5);
        treasure.explore(Arrays.asList(e1, e2));
        assertEquals(2, e1.getBag().getValue());
    }

    @Test
    public void restore() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Treasure treasure = new Treasure(5);
        treasure.explore(Arrays.asList(e1, e2));
        treasure.restore();
        assertEquals(5, treasure.getGems().size());
    }
}
