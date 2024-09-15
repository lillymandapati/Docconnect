package com.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.model.QuestionModel;
@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {

	List<QuestionModel> findByTitleContainingIgnoreCase(String Title);



	QuestionModel findByQuestionId(long questionId);

}
