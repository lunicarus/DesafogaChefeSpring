package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
