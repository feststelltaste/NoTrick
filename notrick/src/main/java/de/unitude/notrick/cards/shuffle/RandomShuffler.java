/**
 * update test bla
 * test2
 */
/**
 * update test run
 */
/**
 * test
 */
package de.unitude.notrick.cards.shuffle;

import java.util.Collections;

import de.unitude.notrick.cards.deck.CardDeck;

public class RandomShuffler implements Shuffler {

    private CardDeck cardDeck;

    public RandomShuffler(CardDeck cardDeck) {
	this.cardDeck = cardDeck;
    }

    @Override
    public CardDeck shuffleCards() {
	Collections.shuffle(cardDeck.getAsList());
	return cardDeck;
    }

}
