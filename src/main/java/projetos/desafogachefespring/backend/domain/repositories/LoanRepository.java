package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.backend.domain.entities.LoanStatus;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByStatus(LoanStatus status);
}
