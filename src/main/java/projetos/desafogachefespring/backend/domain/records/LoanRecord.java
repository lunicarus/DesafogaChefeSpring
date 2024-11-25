package projetos.desafogachefespring.backend.domain.records;


import org.springframework.lang.NonNull;
import projetos.desafogachefespring.backend.domain.entities.Colaborator;
import projetos.desafogachefespring.backend.domain.entities.Company;
import projetos.desafogachefespring.backend.domain.entities.Job;

import java.time.LocalDateTime;

public record LoanRecord(
        @NonNull
        Colaborator loanedColaborator,

        Company loaningCompany,

        @NonNull
        Company loanerCompany,

        @NonNull
        Job loanJob,

        @NonNull
        LocalDateTime startTime,

        @NonNull
        LocalDateTime endTime,

        @NonNull
        double agreedPayRate,

        @NonNull
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
