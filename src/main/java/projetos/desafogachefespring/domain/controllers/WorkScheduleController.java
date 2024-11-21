package projetos.desafogachefespring.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.domain.entities.WorkSchedule;
import projetos.desafogachefespring.domain.services.WorkScheduleService;

import java.util.List;

@RestController
@RequestMapping("/work-schedules")
public class WorkScheduleController {

    private final WorkScheduleService workScheduleService;

    public WorkScheduleController(WorkScheduleService workScheduleService) {
        this.workScheduleService = workScheduleService;
    }

    @PostMapping("/")
    public WorkSchedule createWorkSchedule(@RequestBody WorkSchedule workSchedule) {
        return workScheduleService.createWorkSchedule(workSchedule);
    }

    @GetMapping("/{id}")
    public WorkSchedule getWorkScheduleById(@PathVariable Long id) {
        return workScheduleService.findById(id).orElseThrow(() -> new IllegalArgumentException("WorkSchedule not found"));
    }

    @GetMapping("/")
    public List<WorkSchedule> getAllWorkSchedules() {
        return workScheduleService.findAll();
    }

    @PutMapping("/{id}")
    public WorkSchedule updateWorkSchedule(@PathVariable Long id, @RequestBody WorkSchedule updatedSchedule) {
        return workScheduleService.updateWorkSchedule(id, updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkSchedule(@PathVariable Long id) {
        workScheduleService.deleteWorkSchedule(id);
    }
}
