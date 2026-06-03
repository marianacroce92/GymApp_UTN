package com.miGrupo.AppGimnasio.features.exercise;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "exercise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id") private Long id;
    @Column(name = "name") private String name;
    @Column(name = "description") private String description;
    @Column(name = "muscle_group") private String muscleGroup;
    @Column(name = "video_url") private String videoUrl;
    @Column(name = "approved") private Boolean approved;
}
