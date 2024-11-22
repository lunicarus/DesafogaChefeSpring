package projetos.desafogachefespring.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Column()
    private String number;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;


    @Id
    private Long id;

    public Address(String street,
                   String city,
                   String state,
                   String postalCode,
                   String number) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.number = number;
    }

}
