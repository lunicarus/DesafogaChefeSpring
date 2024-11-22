package projetos.desafogachefespring.backend.domain.records;


import org.springframework.lang.NonNull;
import projetos.desafogachefespring.backend.domain.entities.Company;

public record RepresentantRecord(long id,
                                 @NonNull
                                 String name,
                                 @NonNull
                                 Company company
                                 )
{
    public RepresentantRecord {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

    }
}
