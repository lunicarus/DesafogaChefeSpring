package projetos.desafogachefespring.domain.records;
import org.springframework.lang.NonNull;

import java.util.List;

public record JobRecord(
        Long id,
        @NonNull
        String title,
        @NonNull
        double bruteCostPerHour
) {
    public JobRecord {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
        if (bruteCostPerHour <= 0) {
            throw new IllegalArgumentException("Brute cost per hour must be greater than zero.");
        }
    }
}

