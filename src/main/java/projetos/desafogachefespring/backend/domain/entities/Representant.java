package projetos.desafogachefespring.backend.domain.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Representants")
public class Representant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(table = "user", name = "id", nullable = false)
    private User user;

    @OneToOne(optional = false)
    @JoinColumn(name = "loaning_company_id", nullable = false,updatable = false)
    private Company company;

    @Column(nullable = false)
    private String representantName;

}
