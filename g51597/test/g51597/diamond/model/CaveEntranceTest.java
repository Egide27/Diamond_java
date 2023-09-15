package g51597.diamond.model;

import java.util.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CaveEntranceTest {

    @Test
    public void discoverNewTreasureSameSharing() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Cave caveA = new Cave();
        CaveEntrance cave = new CaveEntrance(caveA);
        cave.discoverNewTile(Arrays.asList(e1, e2));
        assertTrue(e1.getBag().equals(e2.getBag()));
    }

    @Test
    public void returnToCompCaseNothingOnTheReturnPath() {
        Game game = new Game();
        List<Explorer> explorers = game.getExplorers();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        Treasure tr1 = new Treasure(10);
        Treasure tr2 = new Treasure(10);

        tr1.explore(explorers);
        tr2.explore(explorers);

        game.getCave().getCurrentEntrance().returnToCamp(explorers);

        assertEquals(10, e1.getBag().getValue());
        assertEquals(10, e2.getBag().getValue());
    }

    @Test
    public void returnToCompCaseOneRubieOnTheReturnTreasures() {
        Game game = new Game();
        List<Explorer> explorers = game.getExplorers();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        Treasure tr1 = new Treasure(15);
        Treasure tr2 = new Treasure(11);

        tr1.explore(explorers);
        tr2.explore(explorers);

        game.getCave().getCurrentEntrance().returnToCamp(explorers);

        assertEquals(12, e1.getBag().getValue());
        assertEquals(12, e2.getBag().getValue());
    }

    @Test
    public void returnToCompCaseOneExplorerReturn() {
        Cave cave = new Cave();
        CaveEntrance caveEntrance = cave.getCurrentEntrance();
        List<Explorer> explorers = new ArrayList<>();
        Treasure tr1 = new Treasure(20);
        Treasure tr2 = new Treasure(11);
        Explorer e1 = new Explorer("Un");
        explorers.add(e1);
        caveEntrance.getPath().add(tr1);
        caveEntrance.getPath().add(tr2);

        caveEntrance.returnToCamp(explorers);

        assertEquals(31, e1.getBag().getValue());

    }

    @Test
    public void addTileToPathTestCaseAddTreasure() {
        Cave cave = new Cave();
        Treasure tr1 = new Treasure(1);
        Treasure tr2 = new Treasure(10);
        cave.getCurrentEntrance().addTileToPath(tr1);
        cave.getCurrentEntrance().addTileToPath(tr2);
        assertEquals(2, cave.getCurrentEntrance().getPath().size());
    }

    @Test
    public void addTileToPathTestCaseAddHazard() {
        Cave cave = new Cave();
        Hazard hazard1 = new Hazard(HazardType.SNAKES);
        Hazard hazard2 = new Hazard(HazardType.BATTERING_RAM);
        cave.getCurrentEntrance().addTileToPath(hazard1);
        cave.getCurrentEntrance().addTileToPath(hazard2);
        assertEquals(2, cave.getCurrentEntrance().getPath().size());
    }

    @Test
    public void addTileToPathTestCaseAddHazardAndTreasure() {
        Cave cave = new Cave();
        Hazard hazard1 = new Hazard(HazardType.SNAKES);
        Hazard hazard2 = new Hazard(HazardType.BATTERING_RAM);
        Treasure tr1 = new Treasure();
        Treasure tr2 = new Treasure(10);
        cave.getCurrentEntrance().addTileToPath(tr1);
        cave.getCurrentEntrance().addTileToPath(tr2);
        cave.getCurrentEntrance().addTileToPath(hazard1);
        cave.getCurrentEntrance().addTileToPath(hazard2);
        assertEquals(4, cave.getCurrentEntrance().getPath().size());
    }

    @Test
    public void makeLastTileExploredTest() {
        Treasure firstTreasure = new Treasure(10);
        Treasure lastDiscoveredTreasure = new Treasure(5);
        firstTreasure.transferGemsFrom(lastDiscoveredTreasure);
    }

}
