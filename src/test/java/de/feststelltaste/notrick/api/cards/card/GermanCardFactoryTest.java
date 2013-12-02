package de.feststelltaste.notrick.api.cards.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class GermanCardFactoryTest {

    @Test
    public void createAEichelZehnerCard() {
        Card eichelZehner = new Card(GermanSuit.EICHEL, GermanType.ZEHNER);
        assertEquals(eichelZehner, GermanCardFactory.create("E", "10"));
    }

    @Test
    public void checkConversionOfSuitCodes() {
        assertEquals(GermanSuit.EICHEL, GermanCardFactory.convertSuitCode("E"));
        assertEquals(GermanSuit.GRUEN, GermanCardFactory.convertSuitCode("G"));
        assertEquals(GermanSuit.HERZ, GermanCardFactory.convertSuitCode("H"));
        assertEquals(GermanSuit.SCHELLEN, GermanCardFactory.convertSuitCode("S"));

        try {
            GermanCardFactory.convertSuitCode("non-existent");
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void testConvertTypeCode() {
        assertEquals(GermanType.ASS, GermanCardFactory.convertTypeCode("A"));
        assertEquals(GermanType.ZEHNER, GermanCardFactory.convertTypeCode("10"));
        assertEquals(GermanType.KOENIG, GermanCardFactory.convertTypeCode("K"));
        assertEquals(GermanType.OBER, GermanCardFactory.convertTypeCode("O"));
        assertEquals(GermanType.UNTER, GermanCardFactory.convertTypeCode("U"));
        assertEquals(GermanType.NEUNER, GermanCardFactory.convertTypeCode("9"));
        assertEquals(GermanType.ACHTER, GermanCardFactory.convertTypeCode("8"));
        assertEquals(GermanType.SIEBNER, GermanCardFactory.convertTypeCode("7"));

        try {
            GermanCardFactory.convertTypeCode("non-existent");
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

}
