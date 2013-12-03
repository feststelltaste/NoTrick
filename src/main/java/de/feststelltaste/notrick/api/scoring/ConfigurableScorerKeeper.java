package de.feststelltaste.notrick.api.scoring;

import java.util.HashMap;
import java.util.Map;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.type.Type;

/**
 * Returns the score according to the configured scores per card, suit or type.
 * 
 */
public class ConfigurableScorerKeeper implements ScoreKeeper {

    private final Map<Card, Integer> scorePerCard;
    private final Map<Suit, Integer> scorePerSuit;
    private final Map<Type, Integer> scorePerType;

    // private for Builder pattern
    private ConfigurableScorerKeeper(ConfigurableScorerKeeperBuilder builder) {
        this.scorePerCard = builder.scorePerCard;
        this.scorePerSuit = builder.scorePerSuit;
        this.scorePerType = builder.scorePerType;
    };

    @Override
    public int determine(CardSet cards) {
        int score = 0;
        for (Card card : cards) {
            if (scorePerCard.containsKey(card)) {
                score += scorePerCard.get(card);
            }
            if (scorePerSuit.containsKey(card.getSuit())) {
                score += scorePerSuit.get(card.getSuit());
            }
            if (scorePerType.containsKey(card.getType())) {
                score += scorePerType.get(card.getType());
            }
        }
        return score;
    }

    public static class ConfigurableScorerKeeperBuilder {

        private Map<Card, Integer> scorePerCard = new HashMap<Card, Integer>();
        private Map<Suit, Integer> scorePerSuit = new HashMap<Suit, Integer>();
        private Map<Type, Integer> scorePerType = new HashMap<Type, Integer>();

        public ConfigurableScorerKeeperBuilder add(Card card, int scoreForCard) {
            this.scorePerCard.put(card, Integer.valueOf(scoreForCard));
            return this;
        }

        public ConfigurableScorerKeeperBuilder add(Suit suit, int scoreForEachCardOfGivenSuit) {
            this.scorePerSuit.put(suit, Integer.valueOf(scoreForEachCardOfGivenSuit));
            return this;
        }

        public ConfigurableScorerKeeperBuilder add(Type type, int scoreForWachCardOfGivenType) {
            this.scorePerType.put(type, Integer.valueOf(scoreForWachCardOfGivenType));
            return this;
        }

        public ConfigurableScorerKeeper build() {
            return new ConfigurableScorerKeeper(this);
        }
    }

}
