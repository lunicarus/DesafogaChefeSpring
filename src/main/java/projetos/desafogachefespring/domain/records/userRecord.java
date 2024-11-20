package projetos.desafogachefespring.domain.records;

public record userRecord( Long id,
                          String login,
                          String password,
                          Boolean isAdmin
) {
    public userRecord {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login cannot be null or blank.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }

    }
}