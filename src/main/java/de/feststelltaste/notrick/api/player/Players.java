package de.feststelltaste.notrick.api.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.rules.RuleSet;

public class Players implements Iterable<Player>{
    
    private List<Player> playerList = new ArrayList<Player>();

    public void shift() {
        shift(1);
    }

    private void shift(int position) {
        Collections.rotate(playerList, position);
    }

    public Player get(int position) {
        return playerList.get(position);
    }

    public Iterator<Player> iterator() {
        return playerList.iterator();
    }

    public void add(Player player) {
        playerList.add(player);
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

    public void orderToEldestPlayer(Card cardThatDeterminesEldestPlayer) {
        int indexOfEldestPlayer = 0;
        
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            if(player.showCards().has(cardThatDeterminesEldestPlayer)){
                indexOfEldestPlayer = i;
                break;
            }
        }
        
        shift(-indexOfEldestPlayer);
        
    }

}
