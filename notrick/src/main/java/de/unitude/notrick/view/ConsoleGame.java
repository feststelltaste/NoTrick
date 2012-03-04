package de.unitude.notrick.view;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.player.Player;

public class ConsoleGame {

    public ConsoleGame() {

	printWelcomeMessage();

	List<Player> players = createPlayer(4);

	RuleSet rules = Rules.getRules(GameMode.NO_TRICK);

    }

    private List<Player> createPlayer(int numberOfPlayers) {
	List<Player> players = new ArrayList<Player>();
	for (int i = 0; i < numberOfPlayers; i++) {
	    players.add(new Player("Player" + i));
	}
	return players;
    }

    private void printWelcomeMessage() {
	// TODO Auto-generated method stub

    }

}
