package com.miGrupo.AppGimnasio.features.objective;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "objective")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "name") private String name;
}
