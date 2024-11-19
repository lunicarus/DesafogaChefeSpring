package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Representant extends User {
    @OneToOne(optional = false)
    @JoinColumn(name = "loaning_company_id", nullable = false)
    private Company company;

    private String Name;

}
