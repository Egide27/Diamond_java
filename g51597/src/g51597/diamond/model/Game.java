package g51597.diamond.model;

import java.util.*;

/**
 *
 * @author Egide Kabanza
 */
public class Game implements Model {

    private List<Explorer> explorers;
    private Cave cave;
    private final int minExplorers = 3;
    private final int maxExplorers = 8;
    private final int firstExplorer = 0;

    /**
     * Create a new game
     */
    public Game() {
        this.explorers = new ArrayList<>();
        this.cave = new Cave();
    }

    @Override
    public boolean addExplorer(Explorer explorer) {
        if (!isItPossibleToAddExplorer()) {
            throw new GameException("La liste des explorateurs est complete!");
        }
        if (explorer != null && !explorers.contains(explorer)) {
            explorers.add(explorer);
            return true;
        }
        return false;
    }

    @Override
    public void moveForward() {
        cave.getCurrentEntrance().discoverNewTile(getExploringExplorers());
        if (cave.getCurrentEntrance().isUnsafe()) {
            for (Explorer explorer : explorers) {
                explorer.runAway();
            }
        }
    }

    @Override
    public boolean isExplorationPhaseOver() {
        return getExploringExplorers().isEmpty();
    }

    @Override
    public Cave getCave() {
        return this.cave;
    }

    @Override
    public List<Explorer> getExplorers() {
        return explorers;
    }

    @Override
    public List<Explorer> getExploringExplorers() {

        List<Explorer> exploringExplorers = new ArrayList<>();
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.EXPLORING) {
                exploringExplorers.add(explorer);
            }
        }
        return exploringExplorers;
    }

    /**
     * Give a list of leavind explorer
     *
     * @return leavingExplorers
     */
    private List<Explorer> getLeavingExplorer() {
        List<Explorer> leavingExplorers = new ArrayList<>();
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.LEAVING) {
                leavingExplorers.add(explorer);
            }
        }
        return leavingExplorers;
    }

    @Override
    public void handleExplorerDecisionToLeave(Explorer explorer) {
        if (!getExploringExplorers().contains(explorer)) {
            throw new GameException("The explorer is not in the current game");
        }
        explorer.takeDecisionToLeave();
    }

    @Override
    public void start() {
        if (!isThereEnoughExplorer() || explorers.size() > maxExplorers) {
            throw new GameException("Le nombre d'explorateurs n'est pas valide");
        }
    }

    @Override
    public boolean isThereEnoughExplorer() {
        return explorers.size() >= minExplorers;
    }

    @Override
    public boolean isItPossibleToAddExplorer() {
        return explorers.size() < maxExplorers;
    }

    @Override
    public Explorer getWinner() {
        Explorer winner = explorers.get(firstExplorer);
        int maxRubies = winner.getFortune();
        if (!isExplorationPhaseOver()) {
            throw new GameException("On ne peut pas designer un gagnant car le jeu n'est pas fini");
        }
        for (Explorer explorer : explorers) {
            if (explorer.getFortune() > maxRubies) {
                winner = explorer;
            }
        }
        return winner;
    }

    @Override
    public void makeExplorersLeave() {
        cave.getCurrentEntrance().makeLastTileExplored();
        this.cave.getCurrentEntrance().returnToCamp(getLeavingExplorer());

        for (Explorer explorer : getLeavingExplorer()) {
            explorer.reachCamp();
        }

    }

    @Override
    public void startNewExplorationPhase() {
        cave.openNewEntrance();
        for (Explorer explorer : explorers) {
            explorer.startExploration();
        }
    }

    @Override
    public void endExplorationPhase() {
        if (isExplorationPhaseOver()) {
            cave.getCurrentEntrance().lockedOut();
        }
        for (Tile tile : cave.getCurrentEntrance().getPath()) {
            if (tile instanceof Treasure) {
                ((Treasure) tile).restore();
                cave.getDeck().putBack(tile);
            } else if (tile instanceof Hazard) {
                Hazard hazard = (Hazard) tile;
                if (!hazard.isExplorersEscapeReason()) {
                    cave.getDeck().putBack(tile);
                }
            }
        }
    }

    @Override
    public boolean isOver() {
        return this.isExplorationPhaseOver() && !this.cave.hasNewEntranceToExplore();
    }

    @Override
    public boolean isExplorationPhaseAborted() {
        return cave.getCurrentEntrance().isUnsafe();
    }

}
