package com.miGrupo.AppGimnasio.features.trainerStudy;
import com.miGrupo.AppGimnasio.features.study.StudyEntity;
import com.miGrupo.AppGimnasio.features.trainer.TrainerProfileEntity;
import jakarta.persistence.*; import lombok.*;
@Entity
@Table(name = "trainer_study")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer_StrudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "trainer_id") private TrainerProfileEntity trainer; }
    @ManyToOne @JoinColumn(name = "study_id") private StudyEntity study;

}
