package de.feststelltaste.notrick.api.player;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

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

    public CardSet showCards() {
	return hand.getAllCards();
    }

    public void take(CardSet cardSet) {
	this.hand.add(cardSet);
    }

    public void take(Card card) {
	this.hand.add(card);
    }

    public String getName() {
	return name;
    }
}
