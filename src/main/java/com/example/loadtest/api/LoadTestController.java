package com.example.loadtest.api;

import com.example.loadtest.bl.ProblemService;
import com.example.loadtest.domain.Problem;
import com.example.loadtest.domain.ProblemRepository;
import com.example.loadtest.domain.QuizSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoadTestController {
    private final ProblemService problemService;

    // GET DB read
    @GetMapping("/problems/{id}")
    public ProblemResponse getProblem(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(50);
        return problemService.get(id);
    }

    // POST DB write (실제 insert)
    @PostMapping("/quiz/submit")
    public QuizSubmissionResponse submitQuiz(@RequestBody QuizRequest request) throws InterruptedException {
        Thread.sleep(100);
        return problemService.submit(
            request.problemId(),
            request.answer()
        );
    }

    // POST internal + external
    @PostMapping("/summary")
    public ProblemResponse summary(@RequestBody SummaryRequest request) throws InterruptedException {
        Thread.sleep(100);
        return problemService.process(request.problemId());
    }
}
