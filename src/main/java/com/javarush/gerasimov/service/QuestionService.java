package com.javarush.gerasimov.service;

import com.javarush.gerasimov.entity.Question;
import com.javarush.gerasimov.repository.QuestionRepository;

import java.util.List;

public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
