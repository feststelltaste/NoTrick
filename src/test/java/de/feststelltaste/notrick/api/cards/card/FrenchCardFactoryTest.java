package de.feststelltaste.notrick.api.cards.card;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class FrenchCardFactoryTest {
    
    @Test
    public void createAEichelZehnerCard(){
	Card eichelZehner = new Card(FrenchSuit.HEART, FrenchType.TEN);
	assertEquals(eichelZehner, FrenchCardFactory.create("H", "10"));
    }

    @Test
    public void checkConversionOfSuitCodes()
    {
	assertEquals(FrenchSuit.CLUB,FrenchCardFactory.convertSuitCode("C"));
	assertEquals(FrenchSuit.DIAMOND,FrenchCardFactory.convertSuitCode("D"));
	assertEquals(FrenchSuit.HEART,FrenchCardFactory.convertSuitCode("H"));
	assertEquals(FrenchSuit.SPADES,FrenchCardFactory.convertSuitCode("S"));
	
	try{
	    FrenchCardFactory.convertSuitCode("non-existent");
	    fail();
	}
	catch (IllegalArgumentException expected) {
	}
    }
    
    @Test
    public void testConvertTypeCode()
    {
	assertEquals(FrenchType.ACE,FrenchCardFactory.convertTypeCode("A"));
	assertEquals(FrenchType.KING,FrenchCardFactory.convertTypeCode("K"));
	assertEquals(FrenchType.QUEEN,FrenchCardFactory.convertTypeCode("Q"));
	assertEquals(FrenchType.JACK,FrenchCardFactory.convertTypeCode("J"));
	assertEquals(FrenchType.TEN,FrenchCardFactory.convertTypeCode("10"));
	assertEquals(FrenchType.NINE,FrenchCardFactory.convertTypeCode("9"));
	assertEquals(FrenchType.EIGTH,FrenchCardFactory.convertTypeCode("8"));
	assertEquals(FrenchType.SEVEN,FrenchCardFactory.convertTypeCode("7"));
	assertEquals(FrenchType.SIX,FrenchCardFactory.convertTypeCode("6"));
	assertEquals(FrenchType.FIVE,FrenchCardFactory.convertTypeCode("5"));
	assertEquals(FrenchType.FOUR,FrenchCardFactory.convertTypeCode("4"));
	assertEquals(FrenchType.THREE,FrenchCardFactory.convertTypeCode("3"));
	assertEquals(FrenchType.TWO,FrenchCardFactory.convertTypeCode("2"));
	
	try{
	    FrenchCardFactory.convertTypeCode("non-existent");
	    fail();
	}
	catch (IllegalArgumentException expected) {
	}
    }

}
