package io.github.alchevrier;

import java.util.HashMap;
import java.util.List;

public class TopStudentOfExam {
    private final HasStudentChangedStrategy hasStudentChangedStrategy;

    public TopStudentOfExam() {
        hasStudentChangedStrategy = new HasStudentChangedByHierarchy();
    }

    public TopStudentOfExam(HasStudentChangedStrategy hasStudentChangedStrategy) {
        this.hasStudentChangedStrategy = hasStudentChangedStrategy;
    }

    public int compute(List<Integer> resultOfExam) {
        var currentQuestionPerStudent = new HashMap<Integer, Integer>();
        var currentRankingPerQuestion = new HashMap<Integer, Integer>();
        var currentRankingPerStudent = new HashMap<Integer, Integer>();

        int topStudentId = -1;

        for (int i = 0; i < resultOfExam.size(); i++) {
            var currentStudentId = resultOfExam.get(i);
            var currentQuestion = currentQuestionPerStudent.getOrDefault(currentStudentId, 0);
            var currentQuestionRanking = currentRankingPerQuestion.getOrDefault(currentQuestion, 0);
            var currentStudentRanking = currentRankingPerStudent.getOrDefault(currentStudentId, 0);

            currentQuestionPerStudent.put(currentStudentId, currentQuestion + 1);
            currentRankingPerQuestion.put(currentQuestion, currentQuestionRanking + 1);
            currentRankingPerStudent.put(currentStudentId, currentQuestionRanking + currentStudentRanking);

            if (hasStudentChangedStrategy.apply(topStudentId, currentStudentId, currentQuestionPerStudent, currentRankingPerStudent)) {
                topStudentId = currentStudentId;
            }
        }

        return topStudentId;
    }
}
