package g51597.diamond.model;

import java.util.List;

/**
 * Facade of Diamant.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 * Facade pattern
 * </a>
 * @see
 * <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 * @author EsiProf
 */
public interface Model {

    /**
     * This methode can be used to add new player (explorer) in the game.
     *
     * @param explorer the explorer to add.
     * @return true if the explorer is added to the explorer's list.
     */
    boolean addExplorer(Explorer explorer);

    /**
     * Make all exploring explorers move forward in the cave. The explorers
     * share what they found.
     */
    void moveForward();

    /**
     * Declares if it's the end of the phase.
     *
     * @return true if it's the end of the phase.
     */
    boolean isExplorationPhaseOver();

    /**
     * Return the cave of the game.
     *
     * @return the game's cave.
     */
    Cave getCave();

    /**
     * Give all explorers of the game. They could be exploring or leaving.
     *
     * @return all the explorers of the game.
     */
    List<Explorer> getExplorers();

    /**
     * Give all explorers which are exploring.
     *
     * @return explorers in the cave.
     */
    List<Explorer> getExploringExplorers();

    /**
     * Consider the choice of the explorer to leave the cave.
     *
     * @param explorer The explorer who make the choice to leave.
     * @throws GameException If the explorer is not in the current game.
     */
    void handleExplorerDecisionToLeave(Explorer explorer);

    /**
     * Check that the number of registered explorers respects the rules.
     *
     * @throws GameException If the number of explorers does not respect the
     * rules.
     */
    void start();

    /**
     * Check if there are enough registered explorers.
     *
     * @return true if there are at laest 3 explorers
     */
    boolean isThereEnoughExplorer();

    /**
     * Check if it is possible to add an explorer
     *
     * @return true if there are less than 8 explorers
     */
    boolean isItPossibleToAddExplorer();

    /**
     * Get the explorer who has the bigest amount of rubies in his bag
     *
     * @return winner, the winner of the game
     */
    Explorer getWinner();

    /**
     * Allows all explorers wishing to quit the cave
     */
    void makeExplorersLeave();

    /**
     * Open a new entrance and put the explorers in the exploring state
     */
    void startNewExplorationPhase();

    /**
     * End the explaration phase, lock the current entrance.
     */
    void endExplorationPhase();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();

    /**
     * Check if the cave being explored is declared unsafe.
     *
     * @return true if the entrance of the cave being explored is unsafe
     */
    boolean isExplorationPhaseAborted();
}
