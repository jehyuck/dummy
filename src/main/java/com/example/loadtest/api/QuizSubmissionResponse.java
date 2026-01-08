package com.example.loadtest.api;

import com.example.loadtest.domain.QuizSubmission;

public record QuizSubmissionResponse(
    Long id,
    String answer
) {
    public static QuizSubmissionResponse from(QuizSubmission qs) {
        return new QuizSubmissionResponse(
            qs.getId(),
            qs.getAnswer()
        );
    }
}

