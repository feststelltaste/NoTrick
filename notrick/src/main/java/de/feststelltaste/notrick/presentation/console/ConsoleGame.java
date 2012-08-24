package de.feststelltaste.notrick.presentation.console;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ConsoleGame {

    public static void main(String[] argv) throws UnsupportedEncodingException {
	String unicodeMessage = heart() + diamond() + club() + spade();

	PrintStream out = new PrintStream(System.out, true, "UTF-8");
	out.println(unicodeMessage);
    }

    private static String heart() {
	return "\u2665";
    }

    private static String diamond() {
	return "\u2666";
    }

    private static String club() {
	return "\u2663";
    }

    private static String spade() {
	return "\u2660";
    }

}
