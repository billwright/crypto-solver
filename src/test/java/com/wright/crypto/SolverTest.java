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
}
