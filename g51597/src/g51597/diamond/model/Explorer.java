package g51597.diamond.model;

import java.util.Objects;

/**
 * Represent an explorer
 *
 * @author Egide Kabanza
 */
public class Explorer {

    private String pseudonym;
    private Bag bag;
    private State state;
    private Chest chest;
    private boolean bot;
    private AI strategy;
    private BetterAI betterStrat;

    /**
     * Construct an explorer
     *
     * @param pseudonym
     */
    public Explorer(String pseudonym) {
        this.pseudonym = pseudonym;
        state = State.CAMPING;
        bag = new Bag();
        this.chest = new Chest();
    }

    /**
     * Indicate that the explorer decides to leave the cave by changing his
     * status
     */
    public void takeDecisionToLeave() {
        state = State.LEAVING;
    }

    /**
     * Add gem in the bag
     *
     * @param gem
     */
    public void addToBag(Gem gem) {
        bag.addGem(gem);
    }

    /**
     * Get the pseudonym of an explorer
     *
     * @return pseudonym
     */
    public String getPseudonym() {
        return pseudonym;
    }

    /**
     * Get the bag of an explorer
     *
     * @return bag
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * Get the status of an explorer
     *
     * @return
     */
    public State getState() {
        return state;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.pseudonym);
        return hash;
    }

    /*
    * Every explorer has a different pseudonym
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Explorer other = (Explorer) obj;
        if (!Objects.equals(this.pseudonym, other.pseudonym)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Explorer{" + "pseudonym=" + pseudonym + ", bag=" + bag + ", state=" + state + '}';
    }

    /**
     * Get the number of rubies in the bag
     *
     * @return rubies, number of rubies contained in the bag of the explorer
     */
    public int getFortune() {
        return this.getBag().getValue();
    }

    /**
     * Changes the LEAVING explorer status to CAMPING.
     */
    public void reachCamp() {
        this.chest.saveBag();
        this.state = State.CAMPING;
    }

    /**
     * Allow the explorer to start exploring
     */
    public void startExploration() {
        this.state = State.EXPLORING;
    }

    /**
     * Empty the bag and make the explorer reach the camp.
     */
    public void runAway() {
        this.bag.loseContest();
        this.reachCamp();
    }

    /**
     * Get the nature of the explorer
     *
     * @return true if the explorer is a bot
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * Get the strategy of the bot explorer
     *
     * @return the used strategy
     */
    public AI getStrategy() {
        return strategy;
    }

    /**
     * Create an explorer who is an human
     *
     * @param pseudonyme, the pseudonym of the explorer
     * @return the human explorer
     */
    public static Explorer newHuman(String pseudonyme) {
        Explorer newHumain = new Explorer(pseudonyme);
        newHumain.strategy = null;
        return newHumain;
    }

    /**
     * This method create an explorer who is a bot
     *
     * @param pseudonym, the pseudonym of the bot
     * @param strategy, the strategy of the bot
     * @return the bot explorer
     */
    public static Explorer newBot(String pseudonym, AI strategy) {
        Explorer newBot = new Explorer(pseudonym);
        newBot.bot = true;
        newBot.strategy = strategy;
        return newBot;
    }

    public BetterAI getBetterStrat() {
        return betterStrat;
    }
    
    

}
