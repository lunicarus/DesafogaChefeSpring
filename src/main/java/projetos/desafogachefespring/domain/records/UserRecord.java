package projetos.desafogachefespring.domain.records;

import org.springframework.lang.NonNull;

public record UserRecord(Long id,
                         @NonNull
                         String login,
                         @NonNull
                         String password,
                         @NonNull
                         Boolean isAdmin
) {
    public UserRecord {
        if (login.isBlank()) {
            throw new IllegalArgumentException("Login cannot be null or blank.");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }

    }
}