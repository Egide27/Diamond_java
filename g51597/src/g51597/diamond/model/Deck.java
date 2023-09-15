package g51597.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The deck contains the tiles
 *
 * @author Egide Kabanza
 */
public class Deck {

    private List<Tile> tiles;
    private final int minValue = 0;
    private final int occurenceHsardType = 3;
    private final int occurenceRelic = 5;

    /**
     * Initialise a treasure tile
     */
    public Deck() {
        this.tiles = new ArrayList<>();
        final int[] tab = {1, 2, 3, 4, 5, 5, 7, 7, 9, 11, 11, 13, 14, 15, 17};
        for (int value : tab) {
            Treasure treasure = new Treasure(value);
            tiles.add(treasure);
        }
        for (HazardType type : HazardType.values()) {
            for (int i = minValue; i < occurenceHsardType; i++) {
                Hazard hazard = new Hazard(type);
                tiles.add(hazard);
            }
        }
        for (int i = minValue; i < occurenceRelic; i++) {
            tiles.add(new Relic());
        }

    }

    List<Tile> getTiles() {
        return tiles;
    }

    /**
     * Allows you to flip a card randomly among the list of tiles.
     *
     * @return treasure, the random card
     */
    public Tile getTile() {
        int random = (int) (Math.random() * tiles.size());
        Tile tile = tiles.get(random);
        tiles.remove(tile);
        return tile;
    }

    /**
     * allows to put a card back in the package
     *
     * @param tile, the treasure to put back
     */
    public void putBack(Tile tile) {
        tiles.add(tile);
    }
}
