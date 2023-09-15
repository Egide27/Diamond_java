package g51597.diamond.model;

/**
 *
 * @author Egide Kabanza
 */
public class Cave {

    private int nbExploredEntrance;
    private CaveEntrance currentEntrance;
    private Deck deck;
    private final int nbMaxPhases = 5;
    private int nbTakenRelic;

    public Cave() {
        this.nbExploredEntrance = 0;
        this.currentEntrance = new CaveEntrance(this);
        deck = new Deck();
    }

    /**
     * Get the number of explored entrance
     *
     * @return int, number of the explored entrance
     */
    public int getNbExploredEntrance() {
        return nbExploredEntrance;
    }

    /**
     * Get the current entrance
     *
     * @return CaveEntrance, the current entrance
     */
    public CaveEntrance getCurrentEntrance() {
        return this.currentEntrance;
    }

    /**
     * Get the number of the taken relic
     *
     * @return nbTakenRelic
     */
    public int getNbTakenRelic() {
        return nbTakenRelic;
    }

    /**
     * Check if five entrances has been explored
     *
     * @return true, if less than five entrance has been explored
     */
    public boolean hasNewEntranceToExplore() {
        return nbExploredEntrance < nbMaxPhases;
    }

    /**
     * Open a new cave entrance
     *
     * @throws GameException if the previous exploring phase is not finished
     * @throws GameException if five entrance has already been opened
     */
    public void openNewEntrance() {
        if (!hasNewEntranceToExplore()) {
            throw new GameException("Impossible d'ouvrir une nouvelle grotte");
        }
        this.lockOutCurrentEntrance();
        this.currentEntrance = new CaveEntrance(this);
    }

    /**
     * Lock out the current entrance
     *
     * @throws GameException, if no exploring phase is in progress
     */
    public void lockOutCurrentEntrance() {
        this.currentEntrance.lockedOut();
        this.nbExploredEntrance++;
    }

    /**
     * Get the deck
     *
     * @return deck, the current deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Check if last entrance is declared dangerous.
     *
     * @return true, if is declared dangerous.
     */
    public boolean isLastEntranceUnsafe() {
        return currentEntrance.isUnsafe();
    }

    /**
     * increment by 1 the number every time a relic is removed.
     */
    public void incrementNbTakenRelics() {
        nbTakenRelic++;
    }
}
