package projetos.desafogachefespring.domain.records;
import java.util.List;

public record JobRecord(
        Long id,
        String title,
        double bruteCostPerHour
) {
    public JobRecord {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
        if (bruteCostPerHour <= 0) {
            throw new IllegalArgumentException("Brute cost per hour must be greater than zero.");
        }
    }
}

