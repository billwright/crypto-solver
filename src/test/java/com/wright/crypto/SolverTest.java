package com.wright.crypto;


import org.junit.Test;
import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void testSolver() {
        Solver solver = new Solver("ij uifsf");
        assertEquals("hi there", solver.solve());
    }
}
