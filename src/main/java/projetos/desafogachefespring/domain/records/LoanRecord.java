package projetos.desafogachefespring.domain.records;


import projetos.desafogachefespring.domain.entities.Colaborator;
import projetos.desafogachefespring.domain.entities.Company;
import projetos.desafogachefespring.domain.entities.Job;

import java.time.LocalDateTime;

public record LoanRecord(
        Colaborator loanedColaborator,
        Company loaningCompany,
        Company loanerCompany,
        Job loanJob,
        LocalDateTime startTime,
        LocalDateTime endTime,
        double agreedPayRate,
        String loanStatus
) {
    public LoanRecord {
        if (startTime.isBefore(LocalDateTime.now().plusMinutes(60))) 
            throw new IllegalArgumentException("Loan must be requested at least 60 minutes in advance.");
        
        if (endTime.isBefore(startTime)) 
            throw new IllegalArgumentException("End time must be after start time.");
        if(endTime.isAfter(startTime.plusHours(4)))
            throw new IllegalArgumentException("Loans must last at least 4 hours.");

        if(endTime.isAfter(startTime.plusHours(8)))
            throw new IllegalArgumentException("Loans cannot last more than 8 hours.");

        if(loanJob != loanedColaborator.getJob())
            throw new IllegalArgumentException(" Collaborator cannot work in different jobs.");

        if(agreedPayRate < loanedColaborator.getJob().getBruteCostPerHour())
            throw new IllegalArgumentException(" Agreed value must be equal or greater than Collaborator salary/hour.");


    }
}
