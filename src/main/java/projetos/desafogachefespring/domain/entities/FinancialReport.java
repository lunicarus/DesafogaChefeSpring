package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "loaning_company_id", nullable = false)
    private Company loaningCompany;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loaner_company_id", nullable = false)
    private Company loanerCompany;

    @ManyToOne(optional = false)
    @JoinColumn(name = "colaborator_id", nullable = false)
    private Colaborator colaborator;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private double totalCost;

    @Column(nullable = false)
    private double basePay;

    @Column(nullable = false)
    private double extraPay;

    @Column(nullable = false)
    private double transportationCost;

    public FinancialReport(Loan loan) {
        this.loan = loan;
        this.loaningCompany = loan.getLoaningCompany();
        this.loanerCompany = loan.getLoanerCompany();
        this.colaborator = loan.getColaborator();
        this.startDate = loan.getStartTime();
        this.endDate = loan.getEndTime();
    }
}
