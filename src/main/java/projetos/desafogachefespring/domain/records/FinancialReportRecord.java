package projetos.desafogachefespring.domain.records;

import projetos.desafogachefespring.domain.entities.Loan;

public record FinancialReportRecord(
        Long id,
        Loan loan,
        double hoursWorked,
        double totalCost,
        double basePay,
        double extraPay,
        double transportationCost
) {
    public FinancialReportRecord {
        if (loan == null) {
            throw new IllegalArgumentException("Finanial Report must have associated Loan");
        }
        if (hoursWorked <= 1) {
            throw new IllegalArgumentException("Hours worked must be greater than one.");
        }
        if (totalCost <= 1) {
            throw new IllegalArgumentException("Total cost must be greater than one.");
        }
        if (basePay <= 1) {
            throw new IllegalArgumentException("Base pay must be greater than one.");
        }
        if (transportationCost < 0) {
            throw new IllegalArgumentException("Transportation cost cannot be negative.");
        }
    }
}
