package com.miGrupo.AppGimnasio.features.user_role;
 import com.miGrupo.AppGimnasio.features.role.RoleEntity;
 import com.miGrupo.AppGimnasio.features.user.UserEntity;
 import jakarta.persistence.*;
 import lombok.*;

 import java.util.UUID;

@Entity @Table(name = "user_role")
 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
public class User_RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "user_id") private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "role_id") private RoleEntity role;
}
