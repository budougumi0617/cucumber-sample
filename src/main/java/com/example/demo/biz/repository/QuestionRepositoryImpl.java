package com.example.demo.biz.repository;

import com.example.demo.biz.domain.Questions;
import com.example.demo.biz.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
  private final QuestionMapper mapper;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Questions> findQuestions(List<Integer> genre, int size) {
    List<Questions> questionsList =
        Arrays.asList(
            Questions.builder().genre(1).build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build(),
            Questions.builder().build()
        );

    return null;
  }
}
