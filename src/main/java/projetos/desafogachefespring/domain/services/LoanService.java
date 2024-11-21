package projetos.desafogachefespring.domain.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projetos.desafogachefespring.domain.entities.Loan;
import projetos.desafogachefespring.domain.entities.LoanStatus;
import projetos.desafogachefespring.domain.entities.Representant;
import projetos.desafogachefespring.domain.records.LoanRecord;
import projetos.desafogachefespring.domain.records.RepresentantRecord;
import projetos.desafogachefespring.domain.records.UserRecord;
import projetos.desafogachefespring.domain.repositories.ColaboratorRepository;
import projetos.desafogachefespring.domain.repositories.CompanyRepository;
import projetos.desafogachefespring.domain.repositories.LoanRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public Loan createLoan(LoanRecord record) {


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

    public void deleteLoan(Loan loan) {
        if (loan.getStatus() == LoanStatus.APPROVED || loan.getStatus() == LoanStatus.PENDING) {
            loan.setStatus(LoanStatus.CANCELED);
            loanRepository.deleteById(loan.getId());
        }
    }

    @Scheduled(fixedRate = 60000)
    public void updateLoansToInExecution() {
        List<Loan> approvedLoans = loanRepository.findByStatus(LoanStatus.APPROVED);
        LocalDateTime now = LocalDateTime.now();

        for (Loan loan : approvedLoans) {
            if (loan.getStatus() == LoanStatus.APPROVED && loan.getStartTime().isEqual(now)) {
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
            if (loan.getStatus() == LoanStatus.IN_EXECUTION && (loan.getEndTime().isBefore(now) || loan.getEndTime().isEqual(now))) {
                loan.setStatus(LoanStatus.FINISHED);
                loanRepository.save(loan);
            }
        }
    }

    public void updateLoansToCancelled() {
        List<Loan> approvedLoans = loanRepository.findByStatus(LoanStatus.APPROVED);
        LocalDateTime now = LocalDateTime.now();

        for (Loan loan : approvedLoans) {
            if (loan.getStatus() == LoanStatus.APPROVED || loan.getStatus() == LoanStatus.PENDING) {
                loan.setStatus(LoanStatus.CANCELED);
                loanRepository.save(loan);
            }
        }
    }

}

