package com.example.AppGimnasio.levelAnswer.domain;

import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import jakarta.persistence.*;
import lombok.*;
@Table(name="level_answers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @Entity
public class LevelAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="answer", nullable = false)
    private String answer;

    @Column(name="score",nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name="levelQuestion_id")
    private LevelQuestionEntity levelQuestion;
}
