package com.wright.crypto;


import java.util.HashMap;

public class Solver {

    String puzzleText;

    public Solver(String encryptedText) {
        puzzleText = encryptedText.toUpperCase(); //Use all uppercase letters
    }

    public String solve() {
        return "hi there";
    }

    HashMap<Character, Integer> getFrequencies() {
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        for (int i = 0; i < puzzleText.length(); i++) {
            char ch = puzzleText.charAt(i);
            if (ch < 'A' || ch > 'Z') continue;

            Character c = new Character(ch);
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        return frequencies;
    }
}
