package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.NoTrickException;

/**
 * Thrown to signal a severe error if more card than allowed were added to a hand.
 */
public class TooManyCardsForHandException extends NoTrickException {

    private static final long serialVersionUID = 2093490684218246892L;

}
