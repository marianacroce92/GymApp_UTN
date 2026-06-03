package com.miGrupo.AppGimnasio.features.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name= "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //significa q el id es auto incremental

    private Long id; //ID de la BD

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID uuid;     //ID para el publico. ej dkfsjkdfh Lo especifico como una columna.

    @Column(name = "id") private Long id;
    @Column(name = "dni", unique = true) private String dni;
    @Column(name = "username", unique = true) private String username;
    @Column(name = "email", unique = true) private String email;
    @Column(name = "password_hash") private String passwordHash;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;
    @Column(name = "birth_date") private LocalDate birthDate;
    @Column(name = "gender") private String gender;
    @Column(name = "validated_account") private Boolean validatedAccount;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "deleted_at") private LocalDateTime deletedAt;
    @OneToMany(mappedBy = "user") private List<UserRoleEntity> userRoles; }

}
