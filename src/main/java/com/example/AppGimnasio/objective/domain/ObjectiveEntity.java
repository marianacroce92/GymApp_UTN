package com.example.AppGimnasio.objective.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "objectives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "objective")
    private List<RutineObjectiveEntity> rutineObjectives;
}
