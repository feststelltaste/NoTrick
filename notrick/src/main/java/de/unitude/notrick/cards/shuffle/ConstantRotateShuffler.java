package de.unitude.notrick.cards.shuffle;

import java.util.Collections;

import de.unitude.notrick.cards.deck.CardDeck;

public class ConstantRotateShuffler implements Shuffler {

    private CardDeck cardDeck;

    public ConstantRotateShuffler(CardDeck cardDeck) {
	this.cardDeck = cardDeck;
    }

    @Override
    public CardDeck shuffleCards() {
	Collections.rotate(cardDeck.getAsList(), -distanceToNextType());
	return cardDeck;
    }

    private int distanceToNextType() {
	return cardDeck.getTypes().size();
    }

}
