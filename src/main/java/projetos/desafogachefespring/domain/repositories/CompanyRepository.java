package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
