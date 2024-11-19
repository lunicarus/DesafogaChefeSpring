package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "financial_reports")
public class FinancialReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @Column(nullable = false)
    private double hoursWorked;

    @Column(nullable = false)
    private double totalCost;

    @Column(nullable = false)
    private double basePay;

    @Column(nullable = false)
    private double extraPay;

    private double transportationCost = 15.0;

    public FinancialReport(Loan loan, double hoursWorked, double basePay, double extraPay) {
        this.loan = loan;
        this.hoursWorked = hoursWorked;
        this.basePay = basePay;
        this.extraPay = extraPay;
        this.totalCost = basePay + extraPay + transportationCost;
    }
}
