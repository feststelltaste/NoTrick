package de.feststelltaste.notrick.api.rules;

import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;

public class MustPlaySameSuitIfAvailableRule implements Rule {

    @Override
    public CardSet getPlayableCards(CardSet alreadyPlayedCards, CardSet cardsOnHand) {
        CardSet playableCards = cardsOnHand;

        if (isCardAlreadyPlayed(alreadyPlayedCards)) {
            Suit suitThatsOnTable = suitOfFirstPlayedCard(alreadyPlayedCards);
            if (isSuitOnHand(suitThatsOnTable, cardsOnHand)) {
                playableCards = cardsOfSameSuit(suitThatsOnTable, cardsOnHand);
            }
        }

        return playableCards;
    }

    private boolean isCardAlreadyPlayed(CardSet alreadyPlayedCards) {
        return !alreadyPlayedCards.isEmpty();
    }

    private Suit suitOfFirstPlayedCard(CardSet alreadyPlayedCards) {
        return alreadyPlayedCards.asList().get(0).getSuit();
    }

    private CardSet cardsOfSameSuit(Suit suitOnTable, CardSet cardsOnHand) {
        return cardsOnHand.filter(suitOnTable);
    }

    private boolean isSuitOnHand(Suit suitOfFirstCard, CardSet cardsOnHand) {
        return cardsOnHand.has(suitOfFirstCard);
    }

}
