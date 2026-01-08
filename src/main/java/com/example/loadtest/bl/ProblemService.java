package com.example.loadtest.bl;

import com.example.loadtest.api.ProblemResponse;
import com.example.loadtest.api.QuizSubmissionResponse;
import com.example.loadtest.domain.Problem;
import com.example.loadtest.domain.ProblemRepository;
import com.example.loadtest.domain.QuizSubmission;
import com.example.loadtest.domain.QuizSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final QuizSubmissionRepository quizSubmissionRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public QuizSubmissionResponse submit(Long problemId, String answer) {
        Problem problem = problemRepository.findById(problemId)
            .orElseThrow(() -> new IllegalArgumentException("not found"));

        QuizSubmission submission = new QuizSubmission(problemId, answer);
        return QuizSubmissionResponse.from(quizSubmissionRepository.save(submission));
    }

    @Transactional
    public ProblemResponse process(Long id) {
        Problem problem = problemRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found"));

        problem.increaseView(); // update

        restTemplate.postForObject(
            "http://localhost:8000/summary",
            null,
            String.class
        );

        return ProblemResponse.from(problem);
    }

    @Transactional(readOnly = true)
    public ProblemResponse get(Long id) {
        return ProblemResponse.from(
            problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found")));
    }
}