package com.wright.crypto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/**
 * @author Danny
 * @date 12/21/13 9:16 PM
 */
public class Dictionary {

    private static final String DEFAULT_FILE_NAME = "/words.txt";

    private HashSet<String> words = new HashSet<String>();

    public Dictionary() {
        this(DEFAULT_FILE_NAME);
    }

    public Dictionary(String fileName) {
        String path = getClass().getResource(fileName).getPath();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {
                words.add(line.toUpperCase());
            }
            reader.close();
        } catch (Throwable e) {
        }
    }

    public boolean contains(String s) {
        return words.contains(s);
    }

    public boolean containsSubstring(String s, int start) {
        int end = start + s.length();
        for (String word : words) {
            if (word.length() < end) continue;
            if (word.substring(start, end).equals(s)) return true;
        }
        return false;
    }

    /**
     * Determines whether the given pattern can be a word
     * contained in the dictionary.
     * The pattern should be in all uppercase with missing
     * letters specified as underscores. Example: T_R_NN_S_U__S
     *
     * @param   pattern   the pattern in question (as to whether it can be a valid word).
     * @return  true if the pattern can be a valid word, false otherwise.
     */
    public boolean isWordPossible(String pattern) {
        for (String word : words) {
            if (word.length() != pattern.length()) continue;

            boolean fitsPattern = true;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '_') continue;
                if (pattern.charAt(i) != word.charAt(i)) fitsPattern = false;
            }

            if (fitsPattern) return true;
        }

        return false;
    }
}
