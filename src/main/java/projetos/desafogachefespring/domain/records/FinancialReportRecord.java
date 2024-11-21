package projetos.desafogachefespring.domain.records;

import org.springframework.lang.NonNull;
import projetos.desafogachefespring.domain.entities.Loan;

public record FinancialReportRecord(
        Long id,
        @NonNull
        Loan loan,
        @NonNull
        double hoursWorked,
        @NonNull
        double totalCost,
        @NonNull
        double basePay,
        @NonNull
        double extraPay,
        @NonNull
        double transportationCost
) {
    public FinancialReportRecord {

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
