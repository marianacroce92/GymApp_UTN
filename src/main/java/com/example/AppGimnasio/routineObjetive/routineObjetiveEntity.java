package com.example.AppGimnasio.rutineObjective.domain;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import com.example.AppGimnasio.routine.domain.RoutineEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rutine_objectives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RutineObjectiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "routine_id", nullable = false)
    private RoutineEntity routine;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "objective_id", nullable = false)
    private ObjectiveEntity objective;
}