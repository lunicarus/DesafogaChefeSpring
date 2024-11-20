package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Colaborator  extends User{

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




