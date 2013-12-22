package com.wright.crypto;


import java.util.HashMap;

public class Solver {

    private String cipherText;
    private HashMap<Character, Integer> frequencies;
    private HashMap<Character, Character> keyGuess;

    private static final char[] CHARS_BY_EXPECTED_FREQ = new char[]{'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'Y', 'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'};

    public Solver(String encryptedText) {
        cipherText = encryptedText.toUpperCase(); //Use all uppercase letters
        keyGuess = new HashMap<Character, Character>();

        //Calculate frequencies
        frequencies = new HashMap<Character, Integer>();
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch < 'A' || ch > 'Z') continue;

            Character c = new Character(ch);
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }
    }

    public String getCurrentGuess() {
        String guess = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                Character character = new Character(c);
                if (keyGuess.containsKey(character)) {
                    guess += keyGuess.get(character);
                } else {
                    guess += '_';
                }
            } else {
                guess += c;
            }
        }

        return guess;
    }

    public void makeGuess(char cipherChar, char plainChar) {
        keyGuess.put(new Character(cipherChar), new Character(plainChar));
    }

    public void makeGuess(Character cipherChar, Character plainChar) {
        keyGuess.put(cipherChar, plainChar);
    }

    public String solve() {
        return "hi there";
    }

    HashMap<Character, Integer> getFrequencies() {
        return frequencies;
    }
}
