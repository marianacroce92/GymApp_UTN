package com.miGrupo.AppGimnasio.features.progress;
import com.miGrupo.AppGimnasio.features.client.ClientProfileEntity;
import jakarta.persistence.*;
import lombok.*; import java.time.LocalDate;
@Entity
@Table(name = "progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_profile_id")
    private ClientProfileEntity clientProfile;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "notes")
    private String notes;
}
