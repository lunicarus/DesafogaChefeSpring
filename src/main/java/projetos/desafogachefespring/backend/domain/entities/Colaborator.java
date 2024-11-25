package projetos.desafogachefespring.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="collaborators")
public class Colaborator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(table="work_schedules", name = "id")
    private WorkSchedule workSchedule;

    @ManyToOne
    @JoinColumn(table = "job", name = "id")
    private Job job;

    @Column(nullable = false)
    private String colaboratorName;

    @Column(nullable = false, unique = true)
    private String CPF;

}




