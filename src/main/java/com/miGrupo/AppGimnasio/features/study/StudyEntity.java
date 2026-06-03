package com.miGrupo.AppGimnasio.features.study;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "study")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "name") private String name;
    @Column(name = "institution") private String institution;
}
