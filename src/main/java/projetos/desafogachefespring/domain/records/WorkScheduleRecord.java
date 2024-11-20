package projetos.desafogachefespring.domain.records;

import java.time.LocalTime;
import java.util.Set;

public record WorkScheduleRecord(
        Long id,
        LocalTime beginOfShift,
        LocalTime endOfShift,
        Set<String> workingDays
) {
    public WorkScheduleRecord {
        if (beginOfShift == null)
            throw new IllegalArgumentException("Begin of shift cannot be null.");

        if (endOfShift == null)
            throw new IllegalArgumentException("End of shift cannot be null.");

        if(endOfShift.isBefore(beginOfShift))
            throw new IllegalArgumentException("End of Shift must be after Begin of Shift");

        if(endOfShift.isAfter(beginOfShift.plusHours(10)))
            throw new IllegalArgumentException("Collaborator Shift cannot be longer than 10 hours");

        if(endOfShift.isBefore(beginOfShift.plusHours(4)))
            throw new IllegalArgumentException("Collaborator Shift must be longer than 4 hours");


        if (workingDays == null || workingDays.isEmpty())
            throw new IllegalArgumentException("Working days cannot be null or empty.");
        if (workingDays.size() > 7)
            throw new IllegalArgumentException("There's only 7 working days in tha week");


    }
}
