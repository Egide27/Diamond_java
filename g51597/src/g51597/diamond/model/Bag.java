package g51597.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A bag contains the gains of an explorer
 *
 * @author Egide Kabanza
 */
public class Bag {

    protected List<Gem> gems;
    private final int initialValue = 0;

    /**
     * When it is created, a bag has no rubies
     */
    public Bag() {
        gems = new ArrayList<>();
    }

    /**
     * Add gems in the bag
     *
     * @param gem
     */
    public void addGem(Gem gem) {
        this.gems.add(gem);
    }

    /**
     * Return the amount of rubies contained in the bag
     *
     * @return gems, the rubies contained in the bag
     */
    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public String toString() {
        return "Bag{" + "nbRubies=" + gems + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bag other = (Bag) obj;
        if (this.gems.size() != other.gems.size()) {
            return false;
        }
        return true;
    }

    /**
     * Empty the contents of the bag.
     */
    public void loseContest() {
        this.gems.removeAll(gems);
    }

    /**
     * Calculate gems in the bag
     *
     * @return value, the total of gems contained in the bag
     */
    public int getValue() {
        int value = initialValue;
        for (Gem gem : gems) {
            value += gem.getValue();
        }
        return value;
    }

}
