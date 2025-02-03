package io.github.alchevrier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopStudentOfExamTest {
    private TopStudentOfExam objectUnderTest;

    @BeforeEach
    void setup() {
        objectUnderTest = new TopStudentOfExam();
    }

    @Test
    void givenResultsThenShouldProvideTopStudent() {
        var resultOfExam = List.of(10, 12, 15, 10, 15, 10, 16);
        assertEquals(10, objectUnderTest.compute(resultOfExam));
    }

    @Test
    void givenResultsThenShouldProvideTopStudentSecondCase() {
        var resultOfExam = List.of(10, 12, 15, 10, 15, 10, 16, 12, 12, 12);
        assertEquals(12, objectUnderTest.compute(resultOfExam));
    }
}
