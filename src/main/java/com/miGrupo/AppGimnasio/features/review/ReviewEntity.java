package com.miGrupo.AppGimnasio.features.review;
import com.miGrupo.AppGimnasio.features.trainer.TrainerProfileEntity;
import com.miGrupo.AppGimnasio.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*; import java.time.LocalDateTime;
@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "rating") private Integer rating;
    @Column(name = "comment") private String comment;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne @JoinColumn(name = "client_id") private UserEntity client;
    @ManyToOne @JoinColumn(name = "trainer_id") 10private TrainerProfileEntity trainer;
}
