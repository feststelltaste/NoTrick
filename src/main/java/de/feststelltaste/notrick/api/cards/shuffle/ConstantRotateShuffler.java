package de.feststelltaste.notrick.api.cards.shuffle;

import java.util.Collections;

import de.feststelltaste.notrick.api.cards.deck.CardDeck;

public class ConstantRotateShuffler implements Shuffler {

    private CardDeck cardDeck;
    private int distance;

    public ConstantRotateShuffler(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public ConstantRotateShuffler(CardDeck cardDeck, int distance) {
        this.cardDeck = cardDeck;
    }

    @Override
    public CardDeck shuffleCards() {
        int distanceToRotate = distance == 0 ? -distanceToNextType() : distance;
        Collections.rotate(cardDeck.asList(), distanceToRotate);
        return cardDeck;
    }

    private int distanceToNextType() {
        return cardDeck.numberOfTypes();
    }

}
