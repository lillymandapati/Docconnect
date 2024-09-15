package com.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.dto.CommentDto;
import com.question.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	 List<Comment> findByQuestionQuestionId(long questionId);

}
