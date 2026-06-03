package com.miGrupo.AppGimnasio.features.levelAnswer;
import com.miGrupo.AppGimnasio.features.levelQuestion.LevelQuestionEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "level_answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Level_AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "question_id") private LevelQuestionEntity question;
    @Column(name = "answer") private String answer;
    @Column(name = "score") private Integer score;
}
