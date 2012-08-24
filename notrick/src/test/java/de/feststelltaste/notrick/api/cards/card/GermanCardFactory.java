package de.feststelltaste.notrick.api.cards.card;

import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class GermanCardFactory {

    public static Card create(String suitCode, String typeCode) {
	GermanSuit suit = convertSuitCode(suitCode);
	GermanType type = convertTypeCode(typeCode);
	return new Card(suit, type);
    }

    protected static GermanSuit convertSuitCode(String suitCode) {
	char suitChar = suitCode.charAt(0);

	switch (suitChar) {
	case 'E':
	    return GermanSuit.EICHEL;
	case 'G':
	    return GermanSuit.GRUEN;
	case 'H':
	    return GermanSuit.HERZ;
	case 'S':
	    return GermanSuit.SCHELLEN;
	default:
	    throw new IllegalArgumentException("suitCode + \"" + suitCode + "\" + invalid");
	}
    }

    protected static GermanType convertTypeCode(String typeCode) {
	char suitChar = typeCode.charAt(0);

	switch (suitChar) {
	case 'A':
	    return GermanType.ASS;
	case '1':
	    return GermanType.ZEHNER;
	case 'K':
	    return GermanType.KOENIG;
	case 'O':
	    return GermanType.OBER;
	case 'U':
	    return GermanType.UNTER;
	case '9':
	    return GermanType.NEUNER;
	case '8':
	    return GermanType.ACHTER;
	case '7':
	    return GermanType.SIEBNER;
	default:
	    throw new IllegalArgumentException("typeCode + \"" + typeCode + "\" + invalid");
	}
    }
}
