package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
