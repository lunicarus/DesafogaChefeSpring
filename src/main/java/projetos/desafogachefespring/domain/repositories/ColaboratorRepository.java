package projetos.desafogachefespring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.domain.entities.Colaborator;

public interface ColaboratorRepository extends JpaRepository<Colaborator, Long> {
}
