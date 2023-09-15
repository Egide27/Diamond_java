package g51597.diamond.model;

/**
 *
 * The gems of an explorer are transfered from his bag to his Chest
 *
 * @author Egide Kabanza
 */
public class Chest extends Bag {

    public Chest() {
        super();
    }

    /**
     *
     * Transfers the gems contained in the bag to the chest
     */
    public void saveBag() {
        for (Gem gem : super.gems) {
            this.gems.add(gem);
        }
        super.gems.removeAll(super.gems);
    }
}
