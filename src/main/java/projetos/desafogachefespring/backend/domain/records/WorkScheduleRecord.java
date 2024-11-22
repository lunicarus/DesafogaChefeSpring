package projetos.desafogachefespring.backend.domain.records;

import org.springframework.lang.NonNull;

import java.time.LocalTime;
import java.util.Set;

public record WorkScheduleRecord(
        Long id,
        @NonNull
        LocalTime beginOfShift,
        @NonNull
        LocalTime endOfShift,
        @NonNull
        Set<String> workingDays
) {
    public WorkScheduleRecord {

        if(endOfShift.isBefore(beginOfShift))
            throw new IllegalArgumentException("End of Shift must be after Begin of Shift");

        if(endOfShift.isAfter(beginOfShift.plusHours(10)))
            throw new IllegalArgumentException("Collaborator Shift cannot be longer than 10 hours");

        if(endOfShift.isBefore(beginOfShift.plusHours(4)))
            throw new IllegalArgumentException("Collaborator Shift must be longer than 4 hours");


        if (workingDays.isEmpty())
            throw new IllegalArgumentException("Working days cannot be null or empty.");
        if (workingDays.size() > 7)
            throw new IllegalArgumentException("There's only 7 working days in tha week");


    }
}
