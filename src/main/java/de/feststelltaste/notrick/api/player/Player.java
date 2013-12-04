package de.feststelltaste.notrick.api.player;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.rules.RuleSet;

public abstract class Player {

    protected Hand hand;
    protected String name;
    protected RuleSet rules;
    private PlayerScore score = new PlayerScore();

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

    public Card play(CardSet alreadyPlayedCards) {
        CardSet playableCards = followRules(alreadyPlayedCards, hand.getAllCards());
        Card cardToBePlayed = decide(alreadyPlayedCards, playableCards);
        return hand.take(cardToBePlayed);
    }

    private CardSet followRules(CardSet alreadyPlayedCards, CardSet cardSet) {
        return rules.follow(alreadyPlayedCards, hand.getAllCards());
    }

    protected abstract Card decide(CardSet alreadyPlayedCards, CardSet playableCards);

    public CardSet showCards() {
        return hand.getAllCards();
    }

    public void take(CardSet cardSet) {
        this.hand.add(cardSet);
    }

    public void take(Card card) {
        this.hand.add(card);
    }
    
    public boolean hasCards() {
        return hand.size() > 0;
    }

    public String getName() {
        return name;
    }

    public void learnRules(RuleSet rules) {
        this.rules = rules;
    }
    
    public void addScore(int roundOfCurrentPlay, int currentScore) {
        this.score.addScore(roundOfCurrentPlay, currentScore);
        
    }

    public int getOverallScore() {
        return score.getOverallScore();
    }

    public int getCurrentScore() {
        return score.getCurrentScore();
    }

}
