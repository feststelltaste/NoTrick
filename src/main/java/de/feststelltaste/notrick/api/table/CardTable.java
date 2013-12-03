package de.feststelltaste.notrick.api.table;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardNonExistingException;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.DifferentCardSuitException;
import de.feststelltaste.notrick.api.cards.card.type.Type;

public class CardTable {

    private CardSet cardsOnTable = new CardSet();

    private Class<? extends Type> cardSetType;

    public void add(Card card) {
        checkCard(card);
        cardsOnTable.add(card);
    }

    private void checkCard(Card card) {
        if (card == null) {
            throw new CardNonExistingException();
        } else if (!isFromSameCardType(card)) {
            throw new DifferentCardSuitException();
        }
    }

    private boolean isFromSameCardType(Card card) {
        if (cardSetType == null) {
            cardSetType = card.getType().getClass();
        }
        return cardSetType.isInstance(card.getType());
    }

    public CardSet allCards() {
        return cardsOnTable;
    }

    public Card card(int position) {
        if (position >= cardsOnTable.size())
            throw new CardNonExistingException();

        return cardsOnTable.asList().get(position);
    }

    public void clear() {
        cardsOnTable.clear();
        
    }

}
