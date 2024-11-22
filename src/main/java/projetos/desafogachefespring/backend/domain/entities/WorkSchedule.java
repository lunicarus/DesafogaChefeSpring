package projetos.desafogachefespring.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "work_schedules")
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime beginOfShift;

    @Column(nullable = false)
    private LocalTime endOfShift;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "work_schedule_days", joinColumns = @JoinColumn(name = "work_schedule_id"))
    @Column(name = "working_day")
    private Set<String> workingDays;

    public WorkSchedule(LocalTime beginOfShift, LocalTime endOfShift, Set<String> workingDays) {
        this.beginOfShift = beginOfShift;
        this.endOfShift = endOfShift;
        this.workingDays = workingDays;
    }
}
