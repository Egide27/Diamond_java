package g51597.diamond.view;

import g51597.diamond.model.*;
import java.util.Scanner;

/**
 * The view allow the interaction with the user
 *
 * @author Egide Kabanza
 */
public class View {

    Scanner in;
    Model game;

    /**
     * Create a new Vieuw for a game
     *
     * @param game
     */
    public View(Model game) {
        this.in = new Scanner(System.in);
        this.game = game;
    }
    /**
     * Ask the number of bot wanted
     * @return number, the number the bot wanted
     */
    public int howMuchBot(){
        System.out.println("Combien de bot voulez-vous ajouter ?");
        int number = in.nextInt();
        return number;
    }
    
    /**
     * Ask a pseudonym and create a bot for the game
     * @return newBot
     */
    public Explorer askBot(){
        System.out.println("Entrez un pseudonym pour le BOT ");
        String pseudonym = in.next();
        AI strategy = new BasicAI();
        Explorer newBot =  Explorer.newBot(pseudonym, strategy);
        return newBot;
    }

    /**
     * Create a new explorer with an asked pseudonym
     *
     * @return explorer, the created explorer
     */
    public Explorer askExplorer() {
        System.out.println("Entrez un pseudonym pour un explorateur humain");
        String pseudonym = in.next();
        Explorer explorer = new Explorer(pseudonym);
        return explorer;
    }

    /**
     * Ask to the user if there is a new explorer to add
     *
     * @return boolean, true if there are a are a new explorer to add
     */
    public boolean isThereNewExplorerToAdd() {
        char reponse;
        System.out.println("Ajouter un explorateur ?");
        do {
            System.out.println("O/N");
            reponse = in.next().charAt(0);
            reponse = Character.toUpperCase(reponse);
        } while (reponse != 'O' && reponse != 'N');
        return reponse == 'O';
    }

    public void warnUserAlreadyAdded() {
        System.out.println("You already has added this player!");
    }

    /**
     * Ask to an explorer if he want to continue to explore
     *
     * @param explorer, the explorer that we want the answer
     * @return boolean, true if he want to continue
     */
    public boolean askExplorerChoiseToContinue(Explorer explorer) {
        char answer;
        System.out.println(explorer.getPseudonym() + ", veux-tu continuer ?");
        if(explorer.isBot()){
            if(explorer.getStrategy().shouldIStay(game, explorer)){
                answer = 'O';
            }else{
                answer = 'N';
            }
        }else 
        do {
            System.out.println("O/N");
            answer = in.next().charAt(0);
            answer = Character.toUpperCase(answer);
        } while (answer != 'O' && answer != 'N');
        return answer == 'O';
    }

    /**
     * Display the state of the game
     */
    public void displayGame() {
        System.out.println("----------- Explorateurs ---------------");
        for (Explorer explorer : game.getExploringExplorers()) {
            System.out.print("Pseudonym : "+ explorer.getPseudonym() + " | " );
            System.out.print("Etat : "+ explorer.getState()+ " | ");
            System.out.print("Fortune : " + explorer.getFortune()+ " | ");
            System.out.println("");
        }
        game.getCave();
    }

    /**
     * Display player's status when the game is finished
     */
    public void displayWinner() {
        System.out.println("Bravo " + game.getWinner().getPseudonym() + "!!");
        System.out.println("Tu à gagné!");
    }

    /**
     * Display the path of the discovered caves by the explorers and the state
     * of the exploring explorers
     */
    public void turnResumeDisplay() {
        System.out.println("");
        System.out.println("-------Etat actuel du jeu--------------");
        System.out.println("Voici le chemin des tuiles découvertes");
        for (Tile tile : game.getCave().getCurrentEntrance().getPath()) {
            if(tile instanceof Treasure){
                Treasure treasure = (Treasure) tile;
                System.out.println("[Treasure] | Contenu initial : "+ treasure.getInitNbGems() + " | Contenu actuel : " + treasure.getGems().size());
            }else if(tile instanceof Hazard){
                Hazard hazard = (Hazard) tile;
                System.out.println("[Hazard] | Type : "+ hazard.getType());
            }else{
                Relic relic = (Relic) tile;
                System.out.println("[Relic]" );
            }
                
        }
        System.out.println("-------Contenu des sacs----------------");
        for (Explorer explorer : game.getExploringExplorers()) {
            System.out.println("Sac de "+explorer.getPseudonym() + " | Fortune : "+ explorer.getFortune());
        }
        System.out.println("---   ---   ---   ---   ---   ---   ---");
    }

    /**
     * Warne users that exploration is aborted.
     */
    public void displayRunAway() {
        System.out.println("------------- GAME OVER  ----------");
        System.out.println("L'exploration est avorté!");        
    }
}
