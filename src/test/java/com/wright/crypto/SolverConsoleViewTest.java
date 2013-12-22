package com.wright.crypto;

import org.junit.Test;

/**
 * Created by derek on 12/21/13.
 */
public class SolverConsoleViewTest {

    @Test
    public void testFrequencyDisplay() {
        SolverConsoleView solverConsoleView = new SolverConsoleView(new Solver("ij uifsf"));
        solverConsoleView.printFrequencyTable();
    }
}
