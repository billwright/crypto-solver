package com.wright.crypto;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * @author Danny
 * @date 12/21/13 9:22 PM
 */
public class DictionaryTest {

    @Test
    public void contains() {
        Dictionary dictionary = new Dictionary();
        assertTrue(dictionary.contains("CREATE"));
        assertTrue(dictionary.contains("AARDVARK"));
        assertTrue(dictionary.contains("AMERICA"));
        assertTrue(!dictionary.contains("BLABLABLA"));
        assertTrue(!dictionary.contains("ASDFASDF"));
    }

    @Test
    public void containsSubstring() {
        Dictionary dictionary = new Dictionary();

        assertTrue(dictionary.containsSubstring("REA", 1));
        assertTrue(dictionary.containsSubstring("RDV", 2));
        assertTrue(dictionary.containsSubstring("RIC", 3));
        assertTrue(!dictionary.containsSubstring("ZZZZ", 4));
    }

    @Test
    public void isWordPossible() {
        Dictionary dictionary = new Dictionary();

        assertTrue(dictionary.isWordPossible("___ZING"));
        assertTrue(dictionary.isWordPossible("T_R_NN_S_U__S"));
        assertTrue(!dictionary.isWordPossible("_ZXY__"));
    }
}
