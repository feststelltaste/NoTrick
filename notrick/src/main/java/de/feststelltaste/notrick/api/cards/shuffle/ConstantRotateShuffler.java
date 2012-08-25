package de.feststelltaste.notrick.api.cards.shuffle;

import java.util.Collections;

import de.feststelltaste.notrick.api.cards.deck.CardDeck;

public class ConstantRotateShuffler implements Shuffler {

    private CardDeck cardDeck;

    public ConstantRotateShuffler(CardDeck cardDeck) {
	this.cardDeck = cardDeck;
    }

    @Override
    public CardDeck shuffleCards() {
	Collections.rotate(cardDeck.asList(), -distanceToNextType());
	return cardDeck;
    }

    private int distanceToNextType() {
	return cardDeck.numberOfTypes();
    }

}
