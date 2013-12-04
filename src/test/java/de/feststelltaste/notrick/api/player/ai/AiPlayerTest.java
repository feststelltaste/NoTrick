package de.feststelltaste.notrick.api.player.ai;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.rules.RuleSet;
import de.feststelltaste.notrick.api.rules.NoTrickRules;


public class AiPlayerTest {
    
    @Test
    public void followsTrickTakingRules(){
        CardSet cardsOnTable = new CardSet();
        cardsOnTable.add(TestCard.A1);
        
        Player player = new AiPlayer("", new Hand(8));
        player.take(TestCard.B1);
        player.take(TestCard.A2);
        player.take(TestCard.A3);
        RuleSet rules = new NoTrickRules();
        player.learnRules(rules);
        
        Card cardToBePlayed = player.play(cardsOnTable);
        
        assertEquals(TestCard.A2, cardToBePlayed);
        
    }

}
