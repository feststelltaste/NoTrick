package de.feststelltaste.notrick.api.scoring;

import java.util.TreeMap;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;

public class HighestTypeOfFirstPlayedSuitWinner implements DealWinner {

    @Override
    public Player determineWinner(CardSet cardsOfDeal, Players players) {
        Card firstCard = cardsOfDeal.asList().get(0);
        TreeMap<Card, Player> playerCardRelation = new TreeMap<Card, Player>();
        for (int i = 0; i < cardsOfDeal.size(); i++) {
            if (cardsOfDeal.asList().get(i).getSuit().equals(firstCard.getSuit())) {
                playerCardRelation.put(cardsOfDeal.asList().get(i), players.get(i));
            }
        }
        return playerCardRelation.firstEntry().getValue();
    }

}
