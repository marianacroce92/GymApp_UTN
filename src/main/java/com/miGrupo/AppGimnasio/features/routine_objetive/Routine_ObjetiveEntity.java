package com.miGrupo.AppGimnasio.features.routineObjective;
import com.miGrupo.AppGimnasio.features.objective.ObjectiveEntity;
import com.miGrupo.AppGimnasio.features.routine.RoutineEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "routine_objective")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Routine_ObjetiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "routine_id") private RoutineEntity routine;
    @ManyToOne @JoinColumn(name = "objective_id") private ObjectiveEntity objective;
}
