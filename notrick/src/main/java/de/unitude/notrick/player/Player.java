package de.unitude.notrick.player;

import java.util.List;

import de.unitude.notrick.cards.card.Card;


public class Player {
	
	
	private Hand hand;
	
	public Player(){
	}
	
	public void take(Hand hand) {
		this.hand = hand;
	}
	
	public Card play(){
		return null;
		
	}
	
	public void preserve(List<Card> cardsFromTable, int round){
		
	}
	
	public void memorize(List<Card> cardsFromTable){
		
	}

	public List<Card> showCards() {
		return hand.getAllCards();
	}
	

}
