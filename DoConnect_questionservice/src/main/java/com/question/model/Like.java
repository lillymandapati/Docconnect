package com.question.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionModel question;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "creation_date")
    private Timestamp creationDate;

}
