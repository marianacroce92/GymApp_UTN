package com.miGrupo.AppGimnasio.features.routine;
import com.miGrupo.AppGimnasio.features.trainer.TrainerProfileEntity;
import jakarta.persistence.*;
import lombok.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity
@Table(name = "routine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "title") private String title;
    @Column(name = "description") private String description;
    @Column(name = "level") private String level;
    @Column(name = "price") private BigDecimal price; }
@ManyToOne @JoinColumn(name = "trainer_id") private TrainerProfileEntity trainer;
@Column(name = "created_at") private LocalDateTime createdAt;
}

