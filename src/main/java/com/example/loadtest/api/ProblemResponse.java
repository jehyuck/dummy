package com.example.loadtest.api;

import com.example.loadtest.domain.Problem;

public record ProblemResponse(
    Long id,
    String title
) {
    public static ProblemResponse from(Problem p) {
        return new ProblemResponse(p.getId(), p.getTitle());
    }
}

