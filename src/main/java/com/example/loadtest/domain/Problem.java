package com.example.loadtest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "problem")
@Data
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int viewCount;

    protected Problem() {}

    public Problem(String title) {
        this.title = title;
        this.viewCount = 0;
    }

    public void increaseView() {
        this.viewCount++;
    }

    // getter
}
