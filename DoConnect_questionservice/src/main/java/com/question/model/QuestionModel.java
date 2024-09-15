package com.question.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "questions")
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long questionId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "updation_date")
    private Timestamp updationDate;

    @Column(name = "deactivated_flag")
    private boolean deactivatedFlag;
    private boolean discussionThreadflag;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "resolved")
    private boolean resolved;

    @Column(name = "created_by", length = 50)
    private String createdBy;
    
    private boolean discussionflag;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    



    
}
