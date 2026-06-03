package com.miGrupo.AppGimnasio.features.routineExercise;
import com.miGrupo.AppGimnasio.features.exercise.ExerciseEntity;
import com.miGrupo.AppGimnasio.features.routine.RoutineEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "routine_exercise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Routine_ExcerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "routine_id") private RoutineEntity routine;
    @ManyToOne @JoinColumn(name = "exercise_id") private ExerciseEntity exercise;
    @Column(name = "sets") private Integer sets;
    @Column(name = "reps") private Integer reps;
    @Column(name = "order_index") private Integer orderIndex;
}
