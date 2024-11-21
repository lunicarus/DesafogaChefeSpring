package projetos.desafogachefespring.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.domain.entities.FinancialReport;
import projetos.desafogachefespring.domain.entities.Loan;
import projetos.desafogachefespring.domain.services.FinancialReportService;

import java.util.List;

@RestController
@RequestMapping("/financial-reports")
public class FinancialReportController {

    private final FinancialReportService financialReportService;

    public FinancialReportController(FinancialReportService financialReportService) {
        this.financialReportService = financialReportService;
    }

    @PostMapping("/")
    public FinancialReport createFinancialReport(@RequestBody Loan loan) {
        return financialReportService.createFinancialReport(loan);
    }

    @GetMapping("/{id}")
    public FinancialReport getFinancialReportById(@PathVariable Long id) {
        return financialReportService.findById(id).orElseThrow(() -> new IllegalArgumentException("FinancialReport not found"));
    }

    @GetMapping("/")
    public List<FinancialReport> getAllFinancialReports() {
        return financialReportService.findAll();
    }

    @PutMapping("/{id}")
    public FinancialReport updateFinancialReport(@PathVariable Long id, @RequestBody FinancialReport updatedReport) {
        return financialReportService.updateFinancialReport(id, updatedReport);
    }

}
