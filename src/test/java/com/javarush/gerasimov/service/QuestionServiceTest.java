package com.javarush.gerasimov.service;

import com.javarush.gerasimov.entity.Question;
import com.javarush.gerasimov.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    private List<Question> testQuestions;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testQuestions = Arrays.asList(
                new Question("Question 1", "Answer 1", "Answer 2", 1),
                new Question("Question 1", "Answer 1", "Answer 2", 1)
        );
    }

    @Test
    void shouldReturnAllQuestions() {
        when(questionRepository.findAll()).thenReturn(testQuestions);

        List<Question> result = questionService.getAllQuestions();

        assertEquals(testQuestions, result);
    }
}