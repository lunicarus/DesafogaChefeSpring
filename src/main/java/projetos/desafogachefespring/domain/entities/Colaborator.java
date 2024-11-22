package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Colaborator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_schedule_id")
    private WorkSchedule workSchedule;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(nullable = false)
    private String colaboratorName;

    @Column(nullable = false, unique = true)
    private String CPF;

}




