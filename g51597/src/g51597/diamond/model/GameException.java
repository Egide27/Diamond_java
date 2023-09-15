package g51597.diamond.model;

/**
 * Specific exceptions of the game
 *
 * @author Egide Kabanza
 */
public class GameException extends RuntimeException {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}
