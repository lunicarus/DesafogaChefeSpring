package projetos.desafogachefespring.services;

import projetos.desafogachefespring.domain.entities.Representant;
import projetos.desafogachefespring.domain.records.RepresentantRecord;
import projetos.desafogachefespring.domain.records.UserRecord;
import org.springframework.stereotype.Service;
import projetos.desafogachefespring.domain.repositories.RepresentantRepository;
import projetos.desafogachefespring.domain.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentantService {

    private final RepresentantRepository representantRepository;
    private final UserService userService;

    public RepresentantService(RepresentantRepository representantRepository, UserService userService) {
        this.representantRepository = representantRepository;
        this.userService = userService;
    }

    public Representant createRepresentant(RepresentantRecord record, UserRecord userRecord) {

        userService.createUser(userRecord);

        Representant representant = new Representant();
        representant.setRepresentantName(record.name());
        representant.setCompany(record.company());
        return representantRepository.save(representant);
    }

    public Optional<Representant> findById(Long id) {
        return representantRepository.findById(id);
    }

    public List<Representant> findAll() {
        return representantRepository.findAll();
    }

    public Representant updateRepresentant(Long id, RepresentantRecord record, UserRecord userRecord) {
        return representantRepository.findById(id).map(existingRepresentant -> {
            // Update user-related fields via UserService
            if (userRecord != null) {
                userService.updateUser(userRecord.id(), userRecord);
            }

            // Update representant-specific fields
            existingRepresentant.setRepresentantName(record.name());
            existingRepresentant.setCompany(record.company());
            return representantRepository.save(existingRepresentant);
        }).orElseThrow(() -> new IllegalArgumentException("Representant not found with id: " + id));
    }

    public void deleteRepresentant(Long id) {
        representantRepository.deleteById(id);
    }
}
