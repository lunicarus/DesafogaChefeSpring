package projetos.desafogachefespring.domain.services;

import projetos.desafogachefespring.domain.entities.WorkSchedule;
import projetos.desafogachefespring.domain.repositories.WorkScheduleRepository;

import java.util.List;
import java.util.Optional;

public class WorkScheduleService {

    private final WorkScheduleRepository workScheduleRepository;

    public WorkScheduleService(WorkScheduleRepository workScheduleRepository) {
        this.workScheduleRepository = workScheduleRepository;
    }

    public WorkSchedule createWorkSchedule(WorkSchedule workSchedule) {
        return workScheduleRepository.save(workSchedule);
    }

    public Optional<WorkSchedule> findById(Long id) {
        return workScheduleRepository.findById(id);
    }

    public List<WorkSchedule> findAll() {
        return workScheduleRepository.findAll();
    }

    public WorkSchedule updateWorkSchedule(Long id, WorkSchedule updatedSchedule) {
        return workScheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setBeginOfShift(updatedSchedule.getBeginOfShift());
                    schedule.setEndOfShift(updatedSchedule.getEndOfShift());
                    schedule.setWorkingDays(updatedSchedule.getWorkingDays());
                    return workScheduleRepository.save(schedule);
                })
                .orElseThrow(() -> new IllegalArgumentException("WorkSchedule not found"));
    }

    public void deleteWorkSchedule(Long id) {
        workScheduleRepository.deleteById(id);
    }
}
