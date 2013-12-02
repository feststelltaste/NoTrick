package de.feststelltaste.notrick.api.cards.sorting;

import java.util.Comparator;

import de.feststelltaste.notrick.api.cards.card.Card;

public class PriorityCardComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getSuit().getPriority() < card2.getSuit().getPriority()) {
            return 1;
        } else if (card1.getSuit().getPriority() == card2.getSuit().getPriority()) {
            if (card1.getType().getPriority() < card2.getType().getPriority()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}
