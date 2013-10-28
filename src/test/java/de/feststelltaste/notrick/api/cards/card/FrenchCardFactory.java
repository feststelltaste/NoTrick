package de.feststelltaste.notrick.api.cards.card;

import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class FrenchCardFactory {

    public static Card create(String suitCode, String typeCode) {
	FrenchSuit suit = convertSuitCode(suitCode);
	FrenchType type = convertTypeCode(typeCode);
	return new Card(suit, type);
    }

    protected static FrenchSuit convertSuitCode(String suitCode) {
	char suitChar = suitCode.charAt(0);

	switch (suitChar) {
	case 'C':
	    return FrenchSuit.CLUB;
	case 'D':
	    return FrenchSuit.DIAMOND;
	case 'H':
	    return FrenchSuit.HEART;
	case 'S':
	    return FrenchSuit.SPADES;
	default:
	    throw new IllegalArgumentException("suitCode + \"" + suitCode + "\" + invalid");
	}
    }

    protected static FrenchType convertTypeCode(String typeCode) {
	char suitChar = typeCode.charAt(0);

	switch (suitChar) {
	case 'A':
	    return FrenchType.ACE;
	case 'K':
	    return FrenchType.KING;
	case 'Q':
	    return FrenchType.QUEEN;
	case 'J':
	    return FrenchType.JACK;
	case '1':
	    return FrenchType.TEN;
	case '9':
	    return FrenchType.NINE;
	case '8':
	    return FrenchType.EIGTH;
	case '7':
	    return FrenchType.SEVEN;
	case '6':
	    return FrenchType.SIX;
	case '5':
	    return FrenchType.FIVE;
	case '4':
	    return FrenchType.FOUR;
	case '3':
	    return FrenchType.THREE;
	case '2':
	    return FrenchType.TWO;
	default:
	    throw new IllegalArgumentException("typeCode + \"" + typeCode + "\" + invalid");
	}
    }

}
