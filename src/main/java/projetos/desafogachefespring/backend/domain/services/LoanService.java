package projetos.desafogachefespring.backend.domain.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import projetos.desafogachefespring.backend.domain.entities.Colaborator;
import projetos.desafogachefespring.backend.domain.entities.Loan;
import projetos.desafogachefespring.backend.domain.entities.LoanStatus;
import projetos.desafogachefespring.backend.domain.records.LoanRecord;
import projetos.desafogachefespring.backend.domain.repositories.LoanRepository;
import projetos.desafogachefespring.domain.entities.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final ColaboratorService colaboratorService;

    public LoanService(LoanRepository loanRepository, ColaboratorService colaboratorService) {
        this.loanRepository = loanRepository;
        this.colaboratorService = colaboratorService;
    }

    public Loan createLoan(LoanRecord record) {

        List<Colaborator> availableCollaborators = colaboratorService.findAvailableForLoan();
        if (!availableCollaborators.contains(record.loanedColaborator())) {
            throw new IllegalArgumentException("The specified collaborator is not available for loan.");
        }

        Loan loan = new Loan();
        loan.setLoaningCompany(record.loaningCompany());
        loan.setLoanerCompany(record.loanerCompany());
        loan.setJob(record.loanJob());
        loan.setColaborator(record.loanedColaborator());
        loan.setStartTime(record.startTime());
        loan.setEndTime(record.endTime());
        loan.setStatus(LoanStatus.APPROVED);
        loan.setAgreedPayRate(record.agreedPayRate());

        return loanRepository.save(loan);
    }

    public Optional<Loan> findById(Long id) {
        return loanRepository.findById(id);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public void deleteLoan(Long id) {
        Loan delete = findById(id).orElseThrow(() -> new IllegalArgumentException("Loan not found."));
        if (delete.getStatus() == LoanStatus.APPROVED || delete.getStatus() == LoanStatus.PENDING) {
            delete.setStatus(LoanStatus.CANCELED);
            loanRepository.deleteById(delete.getId());
        }
    }

    @Scheduled(fixedRate = 60000)
    public void updateLoansToInExecution() {
        List<Loan> approvedLoans = loanRepository.findByStatus(LoanStatus.APPROVED);
        LocalDateTime now = LocalDateTime.now();

        for (Loan loan : approvedLoans) {
            if (loan.getStartTime().isEqual(now)) {
                loan.setStatus(LoanStatus.IN_EXECUTION);
                loanRepository.save(loan);
            }
        }
    }

    @Scheduled(fixedRate = 60000)
    public void updateLoansToFinished() {
        List<Loan> inExecutionLoans = loanRepository.findByStatus(LoanStatus.IN_EXECUTION);
        LocalDateTime now = LocalDateTime.now();

        for (Loan loan : inExecutionLoans) {
            if (loan.getEndTime().isBefore(now) || loan.getEndTime().isEqual(now)) {
                loan.setStatus(LoanStatus.FINISHED);
                loanRepository.save(loan);
            }
        }
    }

}

