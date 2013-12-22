package com.wright.crypto;

import org.junit.Test;


public class SolverConsoleViewTest {

    @Test
    public void testFrequencyDisplay() {
        SolverConsoleView solverConsoleView = new SolverConsoleView(new Solver("ij uifsf"));
        solverConsoleView.printFrequencyTable();
    }

    @Test
    public void testFrequencyDisplayWithMixedCase() {
        SolverConsoleView solverConsoleView = new SolverConsoleView(new Solver("This is a LONGER test with Mixed Case"));
        solverConsoleView.printFrequencyTable();
    }

}
