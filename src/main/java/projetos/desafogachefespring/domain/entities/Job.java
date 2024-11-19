package projetos.desafogachefespring.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true)
    private String title;

    @Setter
    @Column(nullable = false)
    private double bruteCostPerHour;

    @Setter
    @ElementCollection
    @CollectionTable(name = "job_functions", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "function")
    private List<String> functions = new ArrayList<>();
}
