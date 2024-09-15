package com.answer.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "answer")
public class AnswerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long answerId;
	private long userId;
	private long questionId;
	private String answerText;

	private String discription;

	private Timestamp creationDate;
	private Timestamp updationDate;

	private Boolean statusApproved;

	private Boolean deactivateFlag;
	private String createdBy;
	
	@OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> comments;
	
}
