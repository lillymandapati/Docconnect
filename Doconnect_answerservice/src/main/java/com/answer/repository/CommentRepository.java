package com.answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.answer.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	// List<Comment> findByQuestionQuestionId(long questionId);

	List<Comment> findByAnswerAnswerId(long answerId);


}
