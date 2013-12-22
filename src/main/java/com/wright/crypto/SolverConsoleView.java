package com.wright.crypto;


public class SolverConsoleView {
    Solver solver;

    public SolverConsoleView(Solver theSolver) {
        solver = theSolver;
    }

    public void printFrequencyTable() {
        for (Character currChar : solver.getFrequencies().keySet()) {
            System.out.println("\t" + currChar + ": " + solver.getFrequencies().get(currChar).toString());
        }
    }
}
