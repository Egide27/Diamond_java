package g51597.diamond.model;

import java.util.Random;

/**
 *
 * @author g51597
 */
public class BetterAI implements AI {
    
    private static Random random = new Random();
    private final int limitValue = random.nextInt();
    private int score;
    private final int scoreRisingRuby = 1;
    private final int decreansingHazard = -3;
    private final int risingScoreRelic = 3;

    @Override
    public boolean shouldIStay(Model game, Explorer bot) {
      
      this.score = bot.getFortune();
      if(game.getCave().getCurrentEntrance().getLastDiscoveredTle() instanceof Hazard ){
          score = score + decreansingHazard;
      }else if(game.getCave().getCurrentEntrance().getLastDiscoveredTle() instanceof Relic){
          score = score + decreansingHazard;
      }
      return score > limitValue;
    }
    
}
