package projetos.desafogachefespring.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.backend.domain.entities.Representant;

public interface RepresentantRepository extends JpaRepository<Representant,Long> {
}
