package com.wright.crypto;


import java.util.*;

public class Solver {

    private String cipherText;
    private HashMap<Character, Integer> frequencies;
    private HashMap<Character, Character> keyGuess;
    private ArrayList<Map.Entry<Character, Integer>> sortedFrequencies;
    private Dictionary dictionary;

    private static final char[] CHARS_BY_EXPECTED_FREQ = new char[]{'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'Y', 'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'};

    public Solver(String encryptedText) {
        cipherText = encryptedText.toUpperCase(); //Use all uppercase letters
        keyGuess = new HashMap<Character, Character>();
        dictionary = new Dictionary();

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

        sortedFrequencies = new ArrayList<Map.Entry<Character, Integer>>();
        for (Map.Entry<Character, Integer> currEntry : frequencies.entrySet()) {
            sortedFrequencies.add(currEntry);
        }
        Collections.sort(sortedFrequencies, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> characterIntegerEntry, Map.Entry<Character, Integer> characterIntegerEntry2) {
                return characterIntegerEntry.getValue().compareTo(characterIntegerEntry2.getValue());
            }
        });
        Collections.reverse(sortedFrequencies);
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

    public boolean isCurrentGuessPossible() {
        String curGuess = getCurrentGuess();
        String curWordPattern = "";

        for (int i = 0; i < curGuess.length(); i++) {
            char c = curGuess.charAt(i);
            if ((c >= 'A' && c <= 'Z') || c == '_' || c == '\'') {
                curWordPattern += c;
            } else {
                if (curWordPattern.length() > 0) {
                    boolean isCurWordPossible = dictionary.isWordPossible(curWordPattern);
                    if (!isCurWordPossible) return false;
                }

                curWordPattern = "";
            }
        }

        return true;
    }

    public void makeGuess(char cipherChar, char plainChar) {
        keyGuess.put(new Character(cipherChar), new Character(plainChar));
    }

    public void makeGuess(Character cipherChar, Character plainChar) {
        keyGuess.put(cipherChar, plainChar);
    }

    public void makeGuessesByFrequency() {
        int i = 0;
        for (Map.Entry<Character, Integer> entry : sortedFrequencies) {
            makeGuess(entry.getKey(), new Character(CHARS_BY_EXPECTED_FREQ[i]));
            i++;
        }
    }

    public String solveByFrequency() {
        ArrayList<Character> options = new ArrayList<Character>();
        for (int i = 0; i < CHARS_BY_EXPECTED_FREQ.length; i++) {
            options.add(CHARS_BY_EXPECTED_FREQ[i]);
        }

        solveByFrequency(0, options);
        return getCurrentGuess();
    }

    private boolean solveByFrequency(int i, ArrayList<Character> options) {
        if (i >= sortedFrequencies.size() || options.size() == 0) return isCurrentGuessPossible();
        else {
            Character cipherChar = sortedFrequencies.get(i).getKey();
            for (int j = 0; j < options.size(); j++) {
                Character plainCharGuess = options.get(j);
                makeGuess(cipherChar, plainCharGuess);

                String currentGuess = getCurrentGuess();

                boolean isCurrentGuessPossible = isCurrentGuessPossible();
                if (!isCurrentGuessPossible) continue;

                ArrayList<Character> newOptions = (ArrayList<Character>)options.clone();
                newOptions.remove(plainCharGuess);

                boolean didWorkOut = solveByFrequency(i+1, newOptions);
                if (didWorkOut) return true;
            }

            return false;
        }
    }

    public String solve() {
        return "hi there";
    }

    HashMap<Character, Integer> getFrequencies() {
        return frequencies;
    }
}
