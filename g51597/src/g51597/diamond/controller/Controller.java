package g51597.diamond.controller;

import g51597.diamond.model.Explorer;
import g51597.diamond.model.Model;
import g51597.diamond.view.View;

/**
 * The dinamique of the game haave to be written
 *
 * @author Egide Kabanza
 */
public class Controller {

    private Model game;
    private View view;

    /**
     * Constructor,
     *
     * @param game, instance of the game to pilot
     * @param view, the view of the game
     */
    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Make the game start
     */
    public void startGame() {
        
        int nbBot = view.howMuchBot();
        for(int i =0; i<nbBot; i++){
             if (!game.addExplorer(view.askBot())) {
                view.warnUserAlreadyAdded();
            }
        }
        
        while (!game.isThereEnoughExplorer()) {
            if (!game.addExplorer(view.askExplorer())) {
                view.warnUserAlreadyAdded();
            }
        }

        while (game.isItPossibleToAddExplorer() && view.isThereNewExplorerToAdd()) {
            game.addExplorer(view.askExplorer());
        }
        game.start(); // On verifie que le nombre d'explorateurs respecte les regles

        do {
            game.startNewExplorationPhase();
            do {
                game.moveForward();
                view.displayGame();
                view.turnResumeDisplay();
                for (Explorer explorer : game.getExploringExplorers()) {
                    if (!view.askExplorerChoiseToContinue(explorer)) {
                        game.handleExplorerDecisionToLeave(explorer);
                    }
                }
                game.makeExplorersLeave();
            } while (!game.isExplorationPhaseOver());

            if (game.isExplorationPhaseAborted()) {
                view.displayRunAway();
            }
            game.endExplorationPhase();

        } while (!game.isOver());

        view.displayWinner();
    }
}
