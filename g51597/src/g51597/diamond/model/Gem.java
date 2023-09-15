package g51597.diamond.model;

/**
 * A gem can be a Diamonf or a ruby
 *
 * @author Egide Kabanza
 */
public enum Gem {
    DIAMOND(5),
    RUBY(1);

    final int value;

    /**
     * Create a gem A diamond if value is 5 ans a ruby is value is 1
     *
     * @param value
     */
    Gem(int value) {
        this.value = value;
    }

    /**
     * Get the value of the gem
     *
     * @return int, the value of the gem
     */
    public int getValue() {
        return this.value;
    }
}
