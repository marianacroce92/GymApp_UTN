package com.miGrupo.AppGimnasio.features.role;
package com.miGrupo.AppGimnasio.features.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name= "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //significa q el id es auto incremental

    private Long id; //ID de la BD

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID uuid;     //ID para el publico. ej dkfsjkdfh Lo especifico como una columna.

    @Column
    private String name;
}
