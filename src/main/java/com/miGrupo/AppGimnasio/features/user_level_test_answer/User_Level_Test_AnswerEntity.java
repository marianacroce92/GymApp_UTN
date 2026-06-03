package com.miGrupo.AppGimnasio.features.userLevelTestAnswer;
import com.miGrupo.AppGimnasio.features.levelAnswer.LevelAnswerEntity;
import com.miGrupo.AppGimnasio.features.userLevelTest.UserLevelTestEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "user_level_test_answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_Level_Test_AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "user_level_test_id") private UserLevelTestEntity userLevelTest;
    @ManyToOne @JoinColumn(name = "level_answer_id") private LevelAnswerEntity levelAnswer;
}
