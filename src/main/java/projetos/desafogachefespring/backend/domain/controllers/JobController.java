package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.services.JobService;
import projetos.desafogachefespring.backend.domain.entities.Job;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.findById(id).orElseThrow(() -> new IllegalArgumentException("Job not found"));
    }

    @GetMapping("/")
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        return jobService.updateJob(id, updatedJob);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}
