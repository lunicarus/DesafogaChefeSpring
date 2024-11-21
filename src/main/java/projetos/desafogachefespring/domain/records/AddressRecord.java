package projetos.desafogachefespring.domain.records;

import org.springframework.lang.NonNull;

public record AddressRecord(
        @NonNull
        Long id,

        @NonNull
        String street,

        @NonNull
        String city,

        @NonNull
        String state,

        @NonNull
        String postalCode
) {
    public AddressRecord {
        if ( street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank.");
        }
        if ( city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank.");
        }
        if (state.isBlank()) {
            throw new IllegalArgumentException("State cannot be null or blank.");
        }
        if (postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be null or blank.");
        }
    }
}
