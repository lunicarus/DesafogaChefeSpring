package projetos.desafogachefespring.domain.services;

import projetos.desafogachefespring.domain.entities.Job;
import projetos.desafogachefespring.domain.repositories.JobRepository;

import java.util.List;
import java.util.Optional;

public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job updateJob(Long id, Job updatedJob) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setTitle(updatedJob.getTitle());
                    job.setBruteCostPerHour(updatedJob.getBruteCostPerHour());
                    return jobRepository.save(job);
                })
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}

