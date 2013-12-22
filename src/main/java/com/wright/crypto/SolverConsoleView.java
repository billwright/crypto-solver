package com.wright.crypto;


import java.util.*;

public class SolverConsoleView {
    Solver solver;

    public SolverConsoleView(Solver theSolver) {
        solver = theSolver;
    }

    public void printFrequencyTable() {
        List<Map.Entry<Character, Integer>> sortedCounts = new ArrayList < Map.Entry<Character, Integer>>();

        for (Map.Entry<Character, Integer> currEntry : solver.getFrequencies().entrySet()) {
            sortedCounts.add(currEntry);
        }
        Collections.sort(sortedCounts, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> characterIntegerEntry, Map.Entry<Character, Integer> characterIntegerEntry2) {
                return characterIntegerEntry.getValue().compareTo(characterIntegerEntry2.getValue());
            }
        });

        Collections.reverse(sortedCounts);
        for (Map.Entry<Character, Integer> currEntry : sortedCounts) {
            System.out.println("\t" + currEntry.getKey() + ": " + currEntry.getValue());
        }
    }
}
