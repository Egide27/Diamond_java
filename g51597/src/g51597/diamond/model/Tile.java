package g51597.diamond.model;

import java.util.List;

/**
 *
 * @author Egide Kabanza
 */
public interface Tile {

    /**
     * The discovered rubies are divided into exploring explorer and the
     * undelivered rubies are left behind
     *
     * @param explorers, list of the explorers that discovered the treasure
     */
    void explore(List<Explorer> explorers);

}
