package g51597.diamond.model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

/**
 * A treasure contains gems that are shared between exploring explorer
 *
 * @author Egide Kabanza
 */
public class Treasure implements Tile {

    private List<Gem> gems;
    private final int initNbGems;
    private final int firstPlace = 0;
    private final int edge = 1;

    /**
     * Create a Treasure with gems gems
     *
     * @param nbGems
     */
    public Treasure(int nbGems) {
        gems = new ArrayList<>();
        initNbGems = nbGems;
        for (int i = firstPlace; i < nbGems; i++) {
            gems.add(Gem.RUBY);
        }
    }

    /**
     * Create a Trasure with a random amount of gems between 1 and 15
     */
    public Treasure() {
        gems = new ArrayList<>();
        initNbGems = ThreadLocalRandom.current().nextInt(1, 16);
        for (int i = firstPlace; i < initNbGems; i++) {
            gems.add(Gem.RUBY);
        }
    }

    /**
     * Get the amount of gems contained in the treasure
     *
     * @return gems, gems contained
     */
    public List<Gem> getGems() {
        return gems;
    }

    /**
     * Get the amount of gems when the treasure is discovered
     *
     * @return initnbRubies, the initial amount of gems
     */
    public int getInitNbGems() {
        return initNbGems;
    }

    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            int rubiesPart = this.gems.size() / explorers.size();
            for (Explorer ex : explorers) {
                for (int i = firstPlace; i < rubiesPart; i++) {
                    ex.addToBag(Gem.RUBY);
                    gems.remove(gems.size() - edge);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Treasure{" + "rubies=" + gems + ", initNbRubies=" + initNbGems + '}';
    }

    /**
     * Initialize the value of the treasure to the initial value
     */
    public void restore() {
        for (int i = gems.size(); i < initNbGems; i++) {
            gems.add(Gem.RUBY);
        }
    }

    /**
     * This method moves rubies from instance o to the current tile
     *
     * @param o, instance
     */
    public void transferGemsFrom(Treasure o) {
        for (int i = firstPlace; i < o.gems.size(); i++) {
            this.gems.add(o.getGems().get(i));
        }
        o.getGems().clear();
    }

}
