package io.github.alchevrier;

import java.util.HashMap;

public class HasStudentChangedByHierarchy implements HasStudentChangedStrategy {
    @Override
    public boolean apply(int topStudentId, Integer currentStudentId, HashMap<Integer, Integer> currentQuestionPerStudent, HashMap<Integer, Integer> currentRankingPerStudent) {
        if (topStudentId == -1) {
            return true;
        }

        var numberOfQuestionAnsweredByTop = currentQuestionPerStudent.get(topStudentId);
        var numberOfQuestionAnsweredByCur = currentQuestionPerStudent.get(currentStudentId);

        if (numberOfQuestionAnsweredByTop > numberOfQuestionAnsweredByCur) {
            return false;
        }

        if (numberOfQuestionAnsweredByCur > numberOfQuestionAnsweredByTop) {
            return true;
        }

        var rankingOfTop = currentRankingPerStudent.get(topStudentId);
        var rankingOfCur = currentRankingPerStudent.get(currentStudentId);
        return rankingOfCur < rankingOfTop;
    }
}
