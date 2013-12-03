package de.feststelltaste.notrick.presentation.console;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.human.HumanPlayer;

public class ConsoleGame {

    public ConsoleGame() {
        Player hp = new HumanPlayer();

    }

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
