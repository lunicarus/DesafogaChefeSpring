package projetos.desafogachefespring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.domain.entities.Representant;

public interface RepresentantRepository extends JpaRepository<Representant,Long> {
}
