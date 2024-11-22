package projetos.desafogachefespring.backend.domain.records;

public record ColaboratorRequest(
        UserRecord userRecord,
        ColaboratorRecord colaboratorRecord
) {}
