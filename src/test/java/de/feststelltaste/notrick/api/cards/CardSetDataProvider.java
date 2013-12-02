package de.feststelltaste.notrick.api.cards;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public class CardSetDataProvider {

    public static CardSet createFullyFilledCardSet() {
        CardSet c = new CardSet();
        c.add(TestCard.A1);
        c.add(TestCard.A2);
        c.add(TestCard.A3);
        c.add(TestCard.B1);
        c.add(TestCard.B2);
        c.add(TestCard.B3);
        return c;
    }

}
