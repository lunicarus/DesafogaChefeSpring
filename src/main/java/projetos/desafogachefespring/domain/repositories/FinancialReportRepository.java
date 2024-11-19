package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.FinancialReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialReportRepository extends JpaRepository<FinancialReport, Long> {
}

