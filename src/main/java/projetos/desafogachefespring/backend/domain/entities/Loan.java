package projetos.desafogachefespring.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "colaborator_id", nullable = false)
    private Colaborator colaborator;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loaning_company_id", nullable = false)
    private Company loaningCompany;

    @ManyToOne()
    @JoinColumn(name = "loaner_company_id")
    private Company loanerCompany;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private double agreedPayRate;

    @OneToOne(optional = false)
    @JoinColumn(name = "loan_job_id", nullable = false)
    private Job job;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LoanStatus status;

    private double transportationCost = 15;

    public Loan(Colaborator colaborator,
                Job job,
                Company loaningCompany,
                Company loanerCompany,
                LocalDateTime startTime,
                LocalDateTime endTime,
                double agreedPayRate) {
        this.colaborator = colaborator;
        this.loaningCompany = loaningCompany;
        this.loanerCompany = loanerCompany;
        this.startTime = startTime;
        this.endTime = endTime;
        this.job = job;
        this.agreedPayRate = agreedPayRate;
        this.status = LoanStatus.PENDING;
    }

    public double calculateTotalCost() {
        long hoursWorked = java.time.Duration.between(startTime, endTime).toHours();
        return (hoursWorked * agreedPayRate) + transportationCost;
    }

}
