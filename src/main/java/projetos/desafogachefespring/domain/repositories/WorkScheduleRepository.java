package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
}
