package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
}
