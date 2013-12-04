package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;

public class AiPlayerFactory {
    
    public static int counterForComputerPlayers = 0;

    public Player getAiPlayer() {
        return new AiPlayer("Player"+ ++counterForComputerPlayers, new Hand(8));
    }
    
    

}
