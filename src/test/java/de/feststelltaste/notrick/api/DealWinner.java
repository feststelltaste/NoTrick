package de.feststelltaste.notrick.api;

import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Player;

public interface DealWinner {

    public Player determineWinner(CardSet cardsOfDeal, OrderedPlayers players);
}
