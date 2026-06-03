package com.miGrupo.AppGimnasio.features.userLevelTest;
import com.miGrupo.AppGimnasio.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*; import java.time.LocalDateTime;
@Entity
@Table(name = "user_level_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_Level_TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "user_id") private UserEntity user;
    @Column(name = "score") private Integer score;
    @Column(name = "result_level") private String resultLevel;
    @Column(name = "created_at") 15private LocalDateTime createdAt;
}
