package io.github.alchevrier;

import java.util.HashMap;

@FunctionalInterface
public interface HasStudentChangedStrategy {
    boolean apply(int topStudentId, Integer currentStudentId, HashMap<Integer, Integer> currentQuestionPerStudent, HashMap<Integer, Integer> currentRankingPerStudent);
}
