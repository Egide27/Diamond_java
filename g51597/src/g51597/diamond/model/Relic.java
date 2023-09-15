package g51597.diamond.model;

import java.util.List;

/**
 *
 * A relic contains one or twoo diamonds
 *
 * @author Egide Kabanza
 */
public class Relic implements Tile {

    private int valueInDiamonds;
    private final int minValueInDiamonds = 1;
    private final int maxValueInDiamonds = 2;
    private final int limitChangementVamlue = 3;
    private final int firstPlace = 0;
    private final int onlyOne = 1;

    /**
     * Create a Relic with containing a diamond
     */
    public Relic() {
        this.valueInDiamonds = 1;
    }

    @Override
    public void explore(List<Explorer> explorers) {
        if (canBeTaken(explorers)) {
            for (int i = firstPlace; i < valueInDiamonds; i++) {
                explorers.get(firstPlace).addToBag(Gem.DIAMOND);
            }
        }
    }

    /**
     * Check if the relic can be taken
     *
     * @param explorers, list of explorers
     * @return true if There is only one explorer in this quest and one who
     * leaves the cave, false otherwise.
     */
    public boolean canBeTaken(List<Explorer> explorers) {
        if ((explorers.size() == onlyOne) && (explorers.get(firstPlace).getState() == State.LEAVING)) {
            return true;
        }
        return false;
    }

    /**
     * Takes the value of the relic to 2 if nbTakenRelics ≥ 3
     *
     * @param nbTakenRelics
     */
    public void convertGemValue(int nbTakenRelics) {
        if (nbTakenRelics < limitChangementVamlue) {
            valueInDiamonds = minValueInDiamonds;
        } else {
            valueInDiamonds = maxValueInDiamonds;
        }
    }

    @Override
    public String toString() {
        return "Relic{" + "valueInDiamonds=" + valueInDiamonds + '}';
    }

}
