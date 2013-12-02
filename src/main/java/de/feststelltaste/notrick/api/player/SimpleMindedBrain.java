package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.rules.RuleSet;
import de.feststelltaste.notrick.api.table.CardTable;

public class SimpleMindedBrain implements Brain {

    private RuleSet rules;

    public SimpleMindedBrain(RuleSet rules) {
        this.rules = rules;
    }

    public Card decide(CardTable cardTable, Hand hand) {
        CardSet playableCards = rules.follow(cardTable.allCards(), hand.getAllCards());
        return playableCards.asList().get(0);
    }

}
