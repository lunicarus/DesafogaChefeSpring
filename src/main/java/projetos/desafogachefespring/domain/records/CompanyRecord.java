package projetos.desafogachefespring.domain.records;


public record CompanyRecord(
        Long id,
        String name,
        String CNPJ,
        String email,
        AddressRecord address
) {
    public CompanyRecord {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Company must have name");
        }
        if (CNPJ == null || CNPJ.isBlank()) {
            throw new IllegalArgumentException("Company must have CNPJ");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Company must have email");
        }
        if (address == null) {
            throw new IllegalArgumentException("Company must have address.");
        }
    }
}
