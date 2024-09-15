package com.answer.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.answer.model.AnswerModel;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerModel, Long> {

	List<AnswerModel> findByanswerTextContainingIgnoreCase(String answerTitle);




}