package projetos.desafogachefespring.backend.domain.entities;


import java.time.Duration;

public class FinancialReportCalculator {

    private static final double DEFAULT_TRANSPORTATION_COST = 15.0;

    public FinancialReport calculateReport(Loan loan) {
        FinancialReport report = new FinancialReport(loan);

        long duration = Duration.between(loan.getStartTime(), loan.getEndTime()).toHours();
        double basePay = loan.getAgreedPayRate() * duration;

        double extraPay = 0;
        if (loan.getAgreedPayRate() > loan.getColaborator().getJob().getBruteCostPerHour()) {
            extraPay = (loan.getAgreedPayRate() - loan.getColaborator().getJob().getBruteCostPerHour()) * duration;
        }

        report.setBasePay(basePay);
        report.setExtraPay(extraPay);
        report.setTransportationCost(DEFAULT_TRANSPORTATION_COST);
        report.setTotalCost(basePay + extraPay + DEFAULT_TRANSPORTATION_COST);

        return report;
    }
}
