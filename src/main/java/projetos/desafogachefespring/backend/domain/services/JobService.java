package projetos.desafogachefespring.backend.domain.services;

import org.springframework.stereotype.Service;
import projetos.desafogachefespring.backend.domain.repositories.JobRepository;
import projetos.desafogachefespring.backend.domain.entities.Job;

import java.util.List;
import java.util.Optional;

@Service
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

