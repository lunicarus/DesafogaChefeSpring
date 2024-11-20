package projetos.desafogachefespring.domain.records;

public record AddressRecord(
        Long id,
        String street,
        String city,
        String state,
        String postalCode
) {
    public AddressRecord {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank.");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank.");
        }
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State cannot be null or blank.");
        }
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be null or blank.");
        }
    }
}
