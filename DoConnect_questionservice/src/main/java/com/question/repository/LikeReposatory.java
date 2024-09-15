package com.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Like;
@Repository
public interface LikeReposatory extends JpaRepository<Like, Long> {

	boolean existsByQuestionQuestionId(long questionId);

}
