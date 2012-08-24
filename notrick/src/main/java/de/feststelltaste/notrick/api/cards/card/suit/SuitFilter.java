package de.feststelltaste.notrick.api.cards.card.suit;

import java.util.ArrayList;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public class SuitFilter {

    public static List<Card> same(Suit suit, List<Card> cards) {
        List<Card> cardsWithSuit = new ArrayList<Card>();
    
        for (Card card : cards) {
            if (card.getSuit() == suit) {
        	cardsWithSuit.add(card);
            }
        }
    
        return cardsWithSuit;
    }

}
