package de.unitude.notrick.player;

import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.Hand;

public class Player {

    private Hand hand;
    private String name;

    public Player() {
	name = "Player";
    }

    public Player(String name) {
	this.name = name;
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

    public String getName(){
	return name;
    }
}
