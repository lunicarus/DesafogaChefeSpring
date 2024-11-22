package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.FinancialReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialReportRepository extends JpaRepository<FinancialReport, Long> {
}

