package com.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.answer.model.Like;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
	boolean existsByAnswerAnswerId(long answerId);


}
