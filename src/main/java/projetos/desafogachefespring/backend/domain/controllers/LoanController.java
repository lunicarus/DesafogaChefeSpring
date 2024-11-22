package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.records.LoanRecord;
import projetos.desafogachefespring.backend.domain.entities.Loan;
import projetos.desafogachefespring.backend.domain.services.LoanService;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/")
    public Loan createLoan(@RequestBody LoanRecord loanRecord) {
        return loanService.createLoan(loanRecord);
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.findById(id).orElseThrow(() -> new IllegalArgumentException("Loan not found with ID: " + id));
    }

    @GetMapping("/")
    public List<Loan> getAllLoans() {
        return loanService.findAll();
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable Long id, @RequestBody LoanRecord updatedLoan) {
        return loanService.findById(id)
                .map(loan -> loanService.createLoan(updatedLoan))
                .orElseThrow(() -> new IllegalArgumentException("Loan not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}
