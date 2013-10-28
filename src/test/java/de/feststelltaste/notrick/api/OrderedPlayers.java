package de.feststelltaste.notrick.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.feststelltaste.notrick.api.player.Player;

public class OrderedPlayers extends Players implements Iterable<Player> {
    
    List<Player> players = new ArrayList<Player>();
    
    public void shift(){
	Collections.rotate(players, 1);
    }
    
    public Player get(int position){
	return players.get(position);
    }

    public Iterator<Player> iterator() {
	return players.iterator();
    }

    public void add(Player p1) {
	players.add(p1);
    }

}
