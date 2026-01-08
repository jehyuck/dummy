package com.example.loadtest.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class QuizSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long problemId;

    private String answer;

    protected QuizSubmission() {}

    public QuizSubmission(Long problemId, String answer) {
        this.problemId = problemId;
        this.answer = answer;
    }
}

