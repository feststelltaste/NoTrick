package de.unitude.notrick.player;

import java.util.List;

import de.unitude.notrick.cards.card.Card;

public class Player {

    private Hand hand;

    public Player() {
    }

    public Player(String string) {
	// TODO Auto-generated constructor stub
    }

    public void memorize(List<Card> cardsFromTable) {

    }

    public Card play() {
	return null;

    }

    public void preserve(List<Card> cardsFromTable, int round) {

    }

    public List<Card> showCards() {
	return hand.getAllCards();
    }

    public void take(Hand hand) {
	this.hand = hand;
    }

}
