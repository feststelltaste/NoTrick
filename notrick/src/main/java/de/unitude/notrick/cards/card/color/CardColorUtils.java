package de.unitude.notrick.cards.card.color;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;

public class CardColorUtils {

    public static List<Card> filterCardsByColor(Color color, List<Card> cards) {
	List<Card> cardsWithColor = new ArrayList<Card>();

	for (Card card : cards) {
	    if (card.getColor() == color) {
		cardsWithColor.add(card);
	    }
	}

	return cardsWithColor;
    }

    public static boolean hasCurrentColor(Color color, List<Card> cards) {
	List<Card> filteredCards = filterCardsByColor(color, cards);
	boolean hasCurrentColor = !filteredCards.isEmpty();
	return hasCurrentColor;
    }

}
