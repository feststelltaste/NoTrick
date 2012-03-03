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

public class RotateShuffler implements Shuffler {

	private CardDeck cardDeck;

	public RotateShuffler(CardDeck cardDeck) {
		this.cardDeck = cardDeck;
	}

	public CardDeck shuffleCards() {
		Collections.rotate(cardDeck.getAsList(), -8);
		return cardDeck;
	}

}
