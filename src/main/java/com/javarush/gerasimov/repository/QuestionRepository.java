package com.javarush.gerasimov.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javarush.gerasimov.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements Repository<Question> {

    public List<Question> findAll() {
        ArrayList<Question> questions = new ArrayList<>();
        try (InputStream inputStream = QuestionRepository.class.getClassLoader().getResourceAsStream("questions.json");
             InputStreamReader reader = inputStream != null ? new InputStreamReader(inputStream) : null) {

            if (reader == null) {
                throw new IllegalArgumentException("File not found");
            }
            Gson gson = new Gson();
            Type questionListType = new TypeToken<List<Question>>() {
            }.getType();
            List<Question> deserializedQuestions = gson.fromJson(reader, questionListType);
            questions.addAll(deserializedQuestions);

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Error while reading questions.json", e);
        }
        return questions;
    }
}