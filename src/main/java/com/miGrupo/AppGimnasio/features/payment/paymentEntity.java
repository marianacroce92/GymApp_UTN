package com.miGrupo.AppGimnasio.features.payment;
import com.miGrupo.AppGimnasio.features.enrollment.EnrollmentEntity;
import jakarta.persistence.*;
import lombok.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @ManyToOne @JoinColumn(name = "enrollment_id") private EnrollmentEntity enrollment;
    @Column(name = "amount") private BigDecimal amount;
    @Column(name = "date") private LocalDateTime date; }
@Column(name = "status") private String status;
}
