package com.example.AppGimnasio.userLevelTest.domain;

import com.example.AppGimnasio.user.domain.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Table(name = "user_level_test")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @Entity

public class UserLevelTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="score")
    private Integer score;
    @Column (name="result_level")
    private ResultLevel resultLevel;
    @Column(name="created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

}
