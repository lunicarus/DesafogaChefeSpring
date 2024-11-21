package projetos.desafogachefespring.domain.services;

import org.springframework.stereotype.Service;
import projetos.desafogachefespring.domain.entities.FinancialReport;
import projetos.desafogachefespring.domain.entities.FinancialReportCalculator;
import projetos.desafogachefespring.domain.entities.Loan;
import projetos.desafogachefespring.domain.repositories.FinancialReportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialReportService {

    private final FinancialReportRepository financialReportRepository;
    private final FinancialReportCalculator financialReportCalculator;

    public FinancialReportService(FinancialReportRepository financialReportRepository,
                                  FinancialReportCalculator financialReportCalculator) {
        this.financialReportRepository = financialReportRepository;
        this.financialReportCalculator = financialReportCalculator;
    }

    public FinancialReport createFinancialReport(Loan loan) {
        FinancialReport report = financialReportCalculator.calculateReport(loan);
        return financialReportRepository.save(report);
    }

    public Optional<FinancialReport> findById(Long id) {
        return financialReportRepository.findById(id);
    }

    public List<FinancialReport> findAll() {
        return financialReportRepository.findAll();
    }

    public FinancialReport updateFinancialReport(Long id, FinancialReport updatedReport) {
        return financialReportRepository.findById(id)
                .map(report -> {
                    report.setLoan(updatedReport.getLoan());
                    report.setBasePay(updatedReport.getBasePay());
                    report.setExtraPay(updatedReport.getExtraPay());
                    report.setStartDate(updatedReport.getStartDate());
                    report.setEndDate(updatedReport.getEndDate());
                    report.setTransportationCost(updatedReport.getTransportationCost());
                    report.setTotalCost(updatedReport.getTotalCost());
                    return financialReportRepository.save(report);
                })
                .orElseThrow(() -> new IllegalArgumentException("FinancialReport not found"));
    }
}
