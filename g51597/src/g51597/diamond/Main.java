package g51597.diamond;

import g51597.diamond.controller.Controller;
import g51597.diamond.model.*;
import g51597.diamond.view.View;

/**
 * Main class
 *
 * @author Egide Kabanza
 */
public class Main {

    public static void main(String [] args) {

        Model game = new Game();
        View view = new View(game);
        Controller controller = new Controller(game, view);
        controller.startGame();
    }

}
