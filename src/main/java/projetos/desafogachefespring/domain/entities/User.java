package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,updatable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private Boolean isAdmin = false;
}
