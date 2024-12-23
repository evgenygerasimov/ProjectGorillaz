package com.javarush.gerasimov.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String text;
    private String option1;
    private String option2;
    private int correctOption;
}

