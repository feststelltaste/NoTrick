package de.feststelltaste.notrick.api.cards;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.suit.TestSuit;
import de.feststelltaste.notrick.api.cards.card.suit.TestType;
import de.feststelltaste.notrick.api.cards.card.type.Type;

public class TestCard extends Card {

    public static final Card A1 = new TestCard(TestSuit.A, TestType.ONE);
    public static final Card A2 = new TestCard(TestSuit.A, TestType.TWO);
    public static final Card A3 = new TestCard(TestSuit.A, TestType.THREE);
    public static final Card B1 = new TestCard(TestSuit.B, TestType.ONE);
    public static final Card B2 = new TestCard(TestSuit.B, TestType.TWO);
    public static final Card B3 = new TestCard(TestSuit.B, TestType.THREE);

    public TestCard(Suit suit, Type type) {
        super(suit, type);
    }

}
