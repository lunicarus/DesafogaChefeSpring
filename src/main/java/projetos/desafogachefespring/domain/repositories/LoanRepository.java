package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
