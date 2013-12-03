package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;

public class ComputerPlayer extends Player {
    
    private final Brain brain = new LoserBrain();;

    public ComputerPlayer(String name, Hand hand) {
        this.name = name;
    }
    
    @Override
    public Card decide(CardSet alreadyPlayedCards, CardSet playableCards) {
        Card cardToBePlayed = brain.decide(alreadyPlayedCards, playableCards);
        return cardToBePlayed;
    }
}
