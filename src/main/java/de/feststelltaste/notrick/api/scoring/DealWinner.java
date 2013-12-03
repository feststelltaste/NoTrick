package de.feststelltaste.notrick.api.scoring;

import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;

public interface DealWinner {

    public Player determineWinner(CardSet cardsOfDeal, Players players);
}
