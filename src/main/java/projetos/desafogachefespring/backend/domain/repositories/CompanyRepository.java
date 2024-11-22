package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
