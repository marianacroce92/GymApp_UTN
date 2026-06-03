package com.miGrupo.AppGimnasio.features.levelQuestion;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "level_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Level_QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id") private Long id;
    @Column(name = "question") private String question;
}
