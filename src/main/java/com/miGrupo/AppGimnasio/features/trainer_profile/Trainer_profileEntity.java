package com.miGrupo.AppGimnasio.features.trainer_profile;
package com.miGrupo.AppGimnasio.features.trainer;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "trainer_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer_profileEntity {

    @Id
    @Column(name = "user_id") private Long userId;
    @OneToOne @MapsId @JoinColumn(name = "user_id") private UserEntity user;
    @Column(name = "bio") private String bio;
    @Column(name = "verified") private Boolean verified;
    @Column(name = "instagram") private String instagram; }
    @Column(name = "whatsapp") private String whatsapp;
}
