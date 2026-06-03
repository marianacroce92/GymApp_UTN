package com.miGrupo.AppGimnasio.features.enrollment;
import com.miGrupo.AppGimnasio.features.routine.RoutineEntity;
import com.miGrupo.AppGimnasio.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*; import java.time.LocalDateTime;
@Column(name = "completed_at") private LocalDateTime completedAt;
@Column(name = "cancelled_at") private LocalDateTime cancelledAt;
}
