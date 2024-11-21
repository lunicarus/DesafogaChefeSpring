package projetos.desafogachefespring.domain.repositories;

import projetos.desafogachefespring.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.domain.entities.LoanStatus;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByStatus(LoanStatus status);
}
