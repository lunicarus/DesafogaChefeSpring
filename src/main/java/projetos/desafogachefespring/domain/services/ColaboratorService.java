package projetos.desafogachefespring.domain.services;

import projetos.desafogachefespring.domain.entities.Colaborator;
import projetos.desafogachefespring.domain.repositories.ColaboratorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboratorService {

    private final ColaboratorRepository colaboratorRepository;
    private final PasswordEncoder passwordEncoder;

    public ColaboratorService(ColaboratorRepository colaboratorRepository, PasswordEncoder passwordEncoder) {
        this.colaboratorRepository = colaboratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Colaborator createColaborator(Colaborator colaborator) {
        colaborator.setPassword(passwordEncoder.encode(colaborator.getPassword()));
        return colaboratorRepository.save(colaborator);
    }

    public Optional<Colaborator> findById(Long id) {
        return colaboratorRepository.findById(id);
    }

    public List<Colaborator> findAll() {
        return colaboratorRepository.findAll();
    }

    public Colaborator updateColaborator(Long id, Colaborator updatedColaborator) {
        return colaboratorRepository.findById(id).map(existingColaborator -> {
            String encryptedPassword = passwordEncoder.encode(updatedColaborator.getPassword());
            existingColaborator.setPassword(encryptedPassword);

            existingColaborator.setColaboratorName(updatedColaborator.getColaboratorName());
            existingColaborator.setWorkSchedule(updatedColaborator.getWorkSchedule());
            existingColaborator.setJob(updatedColaborator.getJob());
            existingColaborator.setCPF(updatedColaborator.getCPF());
            return colaboratorRepository.save(existingColaborator);
        }).orElseThrow(() -> new IllegalArgumentException("Colaborator not found with id: " + id));
    }

    public void deleteColaborator(Long id) {
        colaboratorRepository.deleteById(id);
    }
}
