package g51597.diamond.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void addAndGetExplorerGoodNumberOfExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        assertEquals(2, game.getExplorers().size());
    }

    @Test
    public void addAndGetExplorerGoodExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        /*
         * If this test is false, check if you implement the
         * Explorer's equals method...
         */
        assertTrue(game.getExplorers().contains(e1)
                      && game.getExplorers().contains(e2));
    }

    @Test
    public void treatChoiceToLeave() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        e1.startExploration();
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(e1.getState() == State.LEAVING);
    }

    @Test(expected = RuntimeException.class)
    public void treatChoiceToLeaveException() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.handleExplorerDecisionToLeave(e1);
    }

    @Test
    public void moveForwardExploringExplorerGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        e1.startExploration();
        e2.startExploration();
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        assertTrue(e2.getBag().getValue() >= 0);
    }

    @Test
    public void moveForwardLeavingExplorerDoNotGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        e1.takeDecisionToLeave();
        game.moveForward();
        assertTrue(e1.getBag().getValue() == 0);
    }

    @Test
    public void isOverNoExplorers() {
        Game game = new Game();
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void isOverExploringExplorer() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        e1.startExploration();
        game.addExplorer(e1);
        assertFalse(game.isExplorationPhaseOver());
    }

    @Test
    public void isOverExplorerIsLeaving() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        e1.startExploration();
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void getExploringExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        e1.startExploration();
        e2.startExploration();
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.handleExplorerDecisionToLeave(e1);
        List<Explorer> exploringExplorers = game.getExploringExplorers();
        assertTrue(exploringExplorers.size() == 1
                      && exploringExplorers.contains(e2));
    }

    @Test
    public void isThereEnoughExplorerCaseFalse2explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        game.addExplorer(e1);
        game.addExplorer(e2);
        assertFalse(game.isThereEnoughExplorer());
    }

    @Test
    public void isThereEnoughExplorerCaseTrue4explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        Explorer e3 = new Explorer("Egide");
        Explorer e4 = new Explorer("Armin");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        assertTrue(game.isThereEnoughExplorer());
    }

    @Test
    public void isItPossibleToAddExplorerCaseFalse8explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        Explorer e4 = new Explorer("Quatre");
        Explorer e5 = new Explorer("Cinq");
        Explorer e6 = new Explorer("Six");
        Explorer e7 = new Explorer("Sept");
        Explorer e8 = new Explorer("Huit");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        game.addExplorer(e5);
        game.addExplorer(e6);
        game.addExplorer(e7);
        game.addExplorer(e8);
        assertFalse(game.isItPossibleToAddExplorer());
    }

    @Test
    public void isItPossibleToAddExplorerCasetrue4explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        Explorer e4 = new Explorer("Quatre");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        assertTrue(game.isItPossibleToAddExplorer());
    }

    @Test
    public void startCaseOK5explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        Explorer e4 = new Explorer("Quatre");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        game.start();
    }

    @Test(expected = RuntimeException.class)
    public void startCaseKO2explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.start();
    }

    @Test(expected = RuntimeException.class)
    public void startCaseKO9explorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        Explorer e4 = new Explorer("Quatre");
        Explorer e5 = new Explorer("Cinq");
        Explorer e6 = new Explorer("Six");
        Explorer e7 = new Explorer("Sept");
        Explorer e8 = new Explorer("Huit");
        Explorer e9 = new Explorer("Neuf");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        game.addExplorer(e5);
        game.addExplorer(e6);
        game.addExplorer(e7);
        game.addExplorer(e8);
        game.addExplorer(e9);
        game.start();
    }

    @Test(expected = RuntimeException.class)
    public void getWinnerCaseKOGameNotFinished() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        e1.startExploration();
        e2.startExploration();
        game.addExplorer(e1);
        game.addExplorer(e2);
        e1.addToBag(Gem.RUBY);
        e2.addToBag(Gem.DIAMOND);
        game.getWinner();
    }

    @Test
    public void getWinnerCaseOKGameFinished() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        e1.addToBag(Gem.RUBY);
        e2.addToBag(Gem.DIAMOND);
        e1.startExploration();
        e2.startExploration();
        game.handleExplorerDecisionToLeave(e1);
        game.handleExplorerDecisionToLeave(e2);
        game.getWinner();
    }

    @Test
    public void isExplorationPhaseOverCaseTrueNoExploringExplorers() {
        Game game = new Game();
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void isExplorationPhaseOverCaseFalse2ExploringExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e2);
        e1.startExploration();
        assertFalse(game.isExplorationPhaseOver());
    }

    @Test
    public void makeExplorersLeave() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        Explorer e4 = new Explorer("Quatre");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        e1.startExploration();
        e2.startExploration();
        e3.startExploration();
        e1.takeDecisionToLeave();
        e2.takeDecisionToLeave();
        game.makeExplorersLeave();
        assertEquals(State.CAMPING, e1.getState());
        assertEquals(State.CAMPING, e2.getState());
        assertEquals(State.EXPLORING, e3.getState());
    }

    @Test
    public void startNewExplorationPhaseTest() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        game.addExplorer(e1);
        game.addExplorer(e2);
        e1.startExploration();
        e2.startExploration();
        assertEquals(State.EXPLORING, e1.getState());
        assertEquals(State.EXPLORING, e2.getState());
    }

    @Test
    public void endExplorationPhaseTest() {
        Game game = new Game();
        Explorer e1 = new Explorer("Un");
        Explorer e2 = new Explorer("Deux");
        Explorer e3 = new Explorer("Trois");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        e1.startExploration();
        e2.startExploration();
        e3.startExploration();
        game.startNewExplorationPhase();
        e1.takeDecisionToLeave();
        e2.takeDecisionToLeave();
        e3.takeDecisionToLeave();

        game.endExplorationPhase();
        assertTrue(game.getCave().getCurrentEntrance().getLockedOut());
    }
}
