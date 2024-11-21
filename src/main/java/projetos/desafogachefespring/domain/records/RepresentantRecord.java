package projetos.desafogachefespring.domain.records;


import projetos.desafogachefespring.domain.entities.Company;

public record RepresentantRecord(long id,
                                 String name,
                                 Company company
                                 )
{
    public RepresentantRecord {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (company == null) {
            throw new IllegalArgumentException("Company cannot be null or blank.");
        }
    }
}
