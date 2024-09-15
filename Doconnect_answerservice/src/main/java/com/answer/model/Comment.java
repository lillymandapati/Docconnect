package com.answer.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonBackReference
	@ManyToOne
	//@JoinColumn(name = "answer_id", nullable = false)
	private AnswerModel answer;

	//@Column(name = "user_id")
	private long userId;

	//@Column(nullable = false, length = 1000)
	private String content;

	@Column(name = "creation_date")
	private Timestamp creationDate;

	private String createdBy;
	
}

