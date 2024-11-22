package projetos.desafogachefespring.backend.domain.records;


import org.springframework.lang.NonNull;

public record CompanyRecord(
        Long id,

        @NonNull
        String name,

        @NonNull
        String CNPJ,

        @NonNull
        String email,

        @NonNull
        AddressRecord address
) {
    public CompanyRecord {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Company must have name");
        }
        if ( CNPJ.isBlank()) {
            throw new IllegalArgumentException("Company must have CNPJ");
        }
        if (email.isBlank()) {
            throw new IllegalArgumentException("Company must have email");
        }
    }
}
