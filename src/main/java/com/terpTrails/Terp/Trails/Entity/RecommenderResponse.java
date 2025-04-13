package com.terpTrails.Terp.Trails.Entity;

import java.util.List;
import lombok.Data;

@Data
public class RecommenderResponse {
    private List<String> questions;

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
