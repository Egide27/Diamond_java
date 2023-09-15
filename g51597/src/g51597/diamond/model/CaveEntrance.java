package g51597.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow manage a cave entry
 *
 * @author Egide Kabanza
 */
public class CaveEntrance {

    private Tile lastDiscoveredTile;
    private List<Tile> path;
    private boolean lockedOut;
    private Cave cave;
    private boolean unsafe;
    boolean treasureFound;
    Treasure firstTreasureTile;
    private final int first = 0;
    private final int edge = 1;

    /**
     * Create a new Cave
     *
     * @param cave
     */
    public CaveEntrance(Cave cave) {
        this.path = new ArrayList<>();
        this.cave = cave;
        this.treasureFound = false;
    }

    /**
     * Get the last discovered tile
     *
     * @return lastDiscoveredTile, the last tile discovered
     */
    public Tile getLastDiscoveredTle() {
        return lastDiscoveredTile;
    }

    /**
     * Introduces explorers to a new tile room. The wealth disposed on it is
     * shared equitably.
     *
     * @param explorers,
     */
    public void discoverNewTile(List<Explorer> explorers) {
        Tile theTile = cave.getDeck().getTile();

        if (!treasureFound && theTile instanceof Treasure) {
            firstTreasureTile = (Treasure) theTile;
            treasureFound = true;
        }
        theTile.explore(explorers);
        lastDiscoveredTile = theTile;
        if (lastDiscoveredTile instanceof Hazard) {
            if (path.contains(lastDiscoveredTile)) {
                unsafe = true;
                Hazard theHazard = (Hazard) lastDiscoveredTile;
                theHazard.escape();
            }
        }
        path.add(lastDiscoveredTile);
    }

    @Override
    public String toString() {
        return "Cave{" + "lastDiscoveredTreasure=" + lastDiscoveredTile + '}';
    }

    /**
     * Give the all explored tile during of a cave
     *
     * @return path, a list of explored tile
     */
    public List<Tile> getPath() {
        return path;
    }

    /**
     * This method allows all explorers of the list to explore the path when
     * returning to the camp.
     *
     * @param explorers, the list of explorers
     */
    public void returnToCamp(List<Explorer> explorers) {
        for (int i = path.size() - edge; i >= first; i--) {
            if (path.get(i) instanceof Relic) {
                Relic relic = (Relic) path.get(i);
                if (relic.canBeTaken(explorers)) {
                    cave.incrementNbTakenRelics();
                    relic.convertGemValue(cave.getNbTakenRelic());
                    relic.explore(explorers);
                    path.remove(relic);
                }
            } else {
                path.get(i).explore(explorers);
            }
        }

    }

    /**
     * Add a tile to the path
     *
     * @param tile
     */
    public void addTileToPath(Tile tile) {
        path.add(tile);
    }

    /**
     * Notice if the cave entrance is open
     *
     * @return boolean, true if it is closed
     */
    public boolean getLockedOut() {
        return this.lockedOut;
    }

    /**
     * lock out the entrance
     */
    public void lockedOut() {
        this.lockedOut = true;
    }

    /**
     * Get safety of a cave entrance
     *
     * @return boolean, tue if is is unsafe
     */
    public boolean isUnsafe() {
        return unsafe;
    }

    /**
     * get the first treasure tile
     *
     * @return firstTreasureTile
     */
    public Treasure getFirstTreasureTile() {
        return firstTreasureTile;
    }

    /**
     * If the last tile in the path is a Treasure, the rubies must be moved to
     * the first treasure tile
     */
    public void makeLastTileExplored() {
        if (lastDiscoveredTile instanceof Treasure && (getFirstTreasureTile() != lastDiscoveredTile)) {
            firstTreasureTile.transferGemsFrom((Treasure) lastDiscoveredTile);
        }

    }

}
