package com.javarush.gerasimov.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javarush.gerasimov.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class QuestionRepositoryTest {

    @Mock
    private ClassLoader classLoader;

    private String validJsonContent;
    private String invalidJsonContent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        validJsonContent = "[{\"text\":\"Question 1\"},{\"text\":\"Question 2\"}]";
        invalidJsonContent = "invalid json";
    }

    @Test
    void shouldReturnAllQuestions() {
        InputStream mockInputStream = new ByteArrayInputStream(validJsonContent.getBytes());
        when(classLoader.getResourceAsStream("questions.json")).thenReturn(mockInputStream);

        List<Question> result = null;
        try (InputStream inputStream = classLoader.getResourceAsStream("questions.json")) {
            assert inputStream != null;
            try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                Gson gson = new Gson();
                Type questionListType = new TypeToken<List<Question>>() {
                }.getType();
                result = gson.fromJson(reader, questionListType);
            }
        } catch (Exception e) {
            fail("Failed to process JSON.");
        }

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Question 1", result.getFirst().getText());
    }

    @Test
    void shouldThrowExceptionForInvalidJson() {
        InputStream mockInputStream = new ByteArrayInputStream(invalidJsonContent.getBytes());

        when(classLoader.getResourceAsStream("questions.json")).thenReturn(mockInputStream);

        assertThrows(RuntimeException.class, () -> {
            try (InputStream inputStream = classLoader.getResourceAsStream("questions.json")) {
                assert inputStream != null;
                try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                    Gson gson = new Gson();
                    Type questionListType = new TypeToken<List<Question>>() {
                    }.getType();
                    gson.fromJson(reader, questionListType);
                }
            }
        });
    }
}