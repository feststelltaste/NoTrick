package de.feststelltaste.notrick.api.cards.shuffle;

import java.util.Collections;
import java.util.Random;

import de.feststelltaste.notrick.api.cards.deck.CardDeck;

public class RandomShuffler implements Shuffler {

    private CardDeck cardDeck;
    private Random random;

    public RandomShuffler(CardDeck cardDeck, Random random) {
	this.cardDeck = cardDeck;
	this.random = random;
    }

    public RandomShuffler(CardDeck cardDeck) {
	this(cardDeck, new Random());
    }

    @Override
    public CardDeck shuffleCards() {
	Collections.shuffle(cardDeck.getAsList(), random);
	return cardDeck;
    }

}
