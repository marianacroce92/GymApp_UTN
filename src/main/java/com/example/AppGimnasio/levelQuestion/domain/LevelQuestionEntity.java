package com.example.AppGimnasio.levelQuestion.domain;
import com.example.AppGimnasio.levelAnswer.domain.LevelAnswerEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.List;

@Table(name="level_questions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class LevelQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer id;

    @Column(name="question", nullable = false)
    private String question;

    @OneToMany(mappedBy = "question")
    @JoinColumn(name="user_id")
    private List<LevelAnswerEntity> answers;

}
