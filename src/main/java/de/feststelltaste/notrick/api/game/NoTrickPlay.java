package de.feststelltaste.notrick.api.game;

import java.util.Random;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.dealer.Dealer;
import de.feststelltaste.notrick.api.cards.dealer.FourCardsAtOnceAfterAnotherDealer;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.cards.deck.GermanCardDeck;
import de.feststelltaste.notrick.api.cards.shuffle.RandomShuffler;
import de.feststelltaste.notrick.api.cards.shuffle.Shuffler;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.rules.NoTrickRules;
import de.feststelltaste.notrick.api.rules.RuleSet;
import de.feststelltaste.notrick.api.scoring.DealWinner;
import de.feststelltaste.notrick.api.scoring.HighestTypeOfFirstPlayedSuitWinner;
import de.feststelltaste.notrick.api.scoring.PerTrickScorerKeeper;
import de.feststelltaste.notrick.api.table.CardTable;

public class NoTrickPlay extends Play {

    private final Dealer dealer;
    private final CardTable table = new CardTable();
    private final RuleSet rules = new NoTrickRules();
    private final Players players;
    private final DealWinner dealWinner = new HighestTypeOfFirstPlayedSuitWinner();
    private final PerTrickScorerKeeper scoreKeeper = new PerTrickScorerKeeper();
    
    public NoTrickPlay(Players players) {
        GermanCardDeck cardDeck = new GermanCardDeck();
        Shuffler shuffler = new RandomShuffler(cardDeck, new Random(1L));
        CardDeck cardDeckToBePlayed = shuffler.shuffleCards();
        this.dealer = new FourCardsAtOnceAfterAnotherDealer(cardDeckToBePlayed, players);
        this.players = players;
    }

    public void start() {
        if (players == null) {
            throw new ConfigurationException("Players must be assigned to Play");
        }
        players.takeRules(rules);
        dealer.deal();

        while (!isCurrentPlayOver()) {
            CardSet playedCards = table.allCards();
            for (Player player : players) {
                Card cardToBePlayed = player.play(playedCards);
                table.add(cardToBePlayed);
            }

            Player winner = dealWinner.determineWinner(playedCards, players);
            int score = scoreKeeper.determine(playedCards);
            winner.addScore(roundOfCurrentPlay, score);
            table.clear();

        }

    }

    protected boolean isCurrentPlayOver() {
        return !players.last().hasCards();
    }

}
