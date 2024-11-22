package projetos.desafogachefespring.backend.domain.repositories;

import projetos.desafogachefespring.backend.domain.entities.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface ColaboratorRepository extends JpaRepository<Colaborator, Long> {

    @Query("""
        SELECT c FROM Colaborator c 
        WHERE :currentDay MEMBER OF c.workSchedule.workingDays 
        AND c.workSchedule.beginOfShift <= :currentTime 
        AND c.workSchedule.endOfShift >= :currentTime 
        AND c.id NOT IN (
            SELECT l.colaborator.id FROM Loan l 
            WHERE l.startTime <= :currentTime 
            AND l.endTime >= :currentTime
        )
    """)
    List<Colaborator> findAvailableForLoan(String currentDay, LocalTime currentTime);
}
