package de.feststelltaste.notrick.api.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.player.ai.AiPlayerFactory;

public class PlayersTest {
    
    @Test
    public void canDetermineEldestPlayer(){
        Players players = new Players();
        Player player1 = new AiPlayerFactory().getAiPlayer();
        player1.take(TestCard.A1);
        player1.take(TestCard.A2);
        players.add(player1);
        Player player2 = new AiPlayerFactory().getAiPlayer();
        player2.take(TestCard.B1);
        player2.take(TestCard.B2);
        players.add(player2);
        players.add(new AiPlayerFactory().getAiPlayer());
        players.add(new AiPlayerFactory().getAiPlayer());
        
        players.orderToEldestPlayer(TestCard.B2);
        assertEquals(player2, players.get(0));
        
        
        
    }

}
