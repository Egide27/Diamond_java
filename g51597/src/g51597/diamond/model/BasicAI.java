/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g51597.diamond.model;

import java.util.Random;

/**
 *
 * @author g51597
 */
public class BasicAI implements AI {

    private static Random random = new Random();

    @Override
    public boolean shouldIStay(Model game, Explorer bot) {
        return random.nextInt(10) > 0;
    }

}
