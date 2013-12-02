package de.feststelltaste.notrick.api.player;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.GermanCardFactory;

public class HumanPlayerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void behaviour() {
        HumanPlayer p = new HumanPlayer();
        p.take(GermanCardFactory.create("S", "7"));

    }

}
