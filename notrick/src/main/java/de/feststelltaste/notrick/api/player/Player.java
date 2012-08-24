package de.feststelltaste.notrick.api.player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public class Player {

    private Hand hand;
    private String name;

    public Player() {
	this("Player");
    }

    public Player(String name) {
	this(name, new Hand(8));
    }

    public Player(String name, Hand hand) {
	this.name = name;
	this.hand = hand;
    }

    public void memorize(List<Card> cardsFromTable) {

    }

    public Card play() {
	return null;

    }

    public void preserve(List<Card> cardsFromTable, int round) {

    }

    public List<Card> showCards() {
	return Collections.unmodifiableList(hand.getAllCards());
    }

    public void take(Collection<Card> cards) {
	this.hand.getAllCards().addAll(cards);
    }

    public void take(Card card) {
	this.hand.add(card);
    }

    public String getName() {
	return name;
    }
}
