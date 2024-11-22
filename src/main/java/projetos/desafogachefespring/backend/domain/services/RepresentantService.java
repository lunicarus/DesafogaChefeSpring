package projetos.desafogachefespring.backend.domain.services;

import projetos.desafogachefespring.backend.domain.records.RepresentantRequest;
import projetos.desafogachefespring.backend.domain.repositories.RepresentantRepository;
import projetos.desafogachefespring.backend.domain.entities.Representant;
import projetos.desafogachefespring.backend.domain.entities.User;
import org.springframework.stereotype.Service;

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

    public Representant createRepresentant(RepresentantRequest request) {

        User user = userService.createUser(request.userRecord());
        Representant representant = new Representant();
        representant.setUser(user);

        representant.setRepresentantName(request.representantRecord().name());
        representant.setCompany(request.representantRecord().company());
        return representantRepository.save(representant);
    }

    public Optional<Representant> findById(Long id) {
        return representantRepository.findById(id);
    }

    public List<Representant> findAll() {
        return representantRepository.findAll();
    }

    public Representant updateRepresentant(Long id, RepresentantRequest request) {
        return representantRepository.findById(id).map(existingRepresentant -> {

            User user = userService.createUser(request.userRecord());

            existingRepresentant.setUser(user);

            existingRepresentant.setRepresentantName(request.representantRecord().name());
            existingRepresentant.setCompany(request.representantRecord().company());
            return representantRepository.save(existingRepresentant);
        }).orElseThrow(() -> new IllegalArgumentException("Representant not found with id: " + id));
    }

    public void deleteRepresentant(Long id) {
        representantRepository.deleteById(id);
    }
}
