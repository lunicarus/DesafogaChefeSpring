package projetos.desafogachefespring.domain.records;

public record ColaboratorRequest(
        UserRecord userRecord,
        ColaboratorRecord colaboratorRecord
) {}
