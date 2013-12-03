package de.feststelltaste.notrick.api.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.feststelltaste.notrick.api.rules.RuleSet;

public class Players implements Iterable<Player>{
    
    List<Player> playerList = new ArrayList<Player>();

    public void shift() {
        Collections.rotate(playerList, 1);
    }

    public Player get(int position) {
        return playerList.get(position);
    }

    public Iterator<Player> iterator() {
        return playerList.iterator();
    }

    public void add(Player p1) {
        playerList.add(p1);
    }

    public void takeRules(RuleSet rules) {
        for(Player player : playerList){
            player.learnRules(rules);
        }
    }

    public int size() {
        return playerList.size();
    }

    public Player last() {
       return playerList.get(playerList.size()-1);
    }

}
