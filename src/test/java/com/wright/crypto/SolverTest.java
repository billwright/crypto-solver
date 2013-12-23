package com.wright.crypto;


import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void testSolver() {
        Solver solver = new Solver("ij uifsf");
        assertEquals("hi there", solver.solve());
    }

    @Test
    public void frequencyTest1() {
        Solver solver = new Solver("ABCABA");
        HashMap<Character, Integer> frequencies = solver.getFrequencies();
        assertEquals(3, (int)frequencies.get(new Character('A')));
        assertEquals(2, (int)frequencies.get(new Character('B')));
        assertEquals(1, (int)frequencies.get(new Character('C')));

    }

    @Test
    public void guessTest() {
        Solver solver = new Solver("WHAT'S UP WITH YOU?");
        assertEquals("____'_ __ ____ ___?", solver.getCurrentGuess());

        solver.makeGuess('W', 'T');
        assertEquals("T___'_ __ T___ ___?", solver.getCurrentGuess());
    }

    @Test
    public void guessByFreqTest() {
        Solver solver = new Solver("THIS IS A COOL TEST THAT WILL GUESS AT THE ANSWER BY ANALYZING FREQUENCIES -- AND ONLY FREQUENCIES. :)");
        solver.makeGuessesByFrequency();
        System.out.println(solver.getCurrentGuess());
    }

    @Test
    public void isCurrentGuessPossible() {
        Solver solver = new Solver(Encoder.rotation("WHAT'S UP?", 1));

        solver.makeGuess('X', 'W');
        assertTrue(solver.isCurrentGuessPossible());

        solver.makeGuess('B', 'X');
        assertTrue(!solver.isCurrentGuessPossible());
    }

    @Test
    public void solveByFrequencies() {
        String cipherText = "THIS IS A COOL TEST THAT WILL GUESS AT THE ANSWER BY ANALYZING FREQUENCIES -- AND ONLY FREQUENCIES. :)";
        Solver solver = new Solver(Encoder.rotation(cipherText, 5));

        String plainText = solver.solveByFrequency();
        System.out.println(plainText);
        assertEquals(cipherText, plainText);
    }
}
