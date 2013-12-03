package de.feststelltaste.notrick.api.player.human;

import org.apache.log4j.Logger;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.player.Player;

public class HumanPlayer extends Player {

    public static final Logger log = Logger.getLogger(HumanPlayer.class);
    private Card choosenCard;

    @Override
    public Card play() {
        return choosenCard;
    }

    public void choosenCardToPlay(Card c) {
        log.info("Waiting for player " + this.getName() + ".");
        this.choosenCard = c;
    }

}
